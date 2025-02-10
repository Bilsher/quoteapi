package com.example.quotesender.service;

import com.example.quotesender.model.User;
import com.example.quotesender.repository.UserEntity;
import com.example.quotesender.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String userRegistration(User user,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws IOException{
        if(authCheck(request)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return "You already authorized";
        }

        if (userRepository.existsByUserLogin(user.getUserLogin())) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return "This login already taken";
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUserLogin(user.getUserLogin());
        userEntity.setUserPassword(user.getUserPassword());
        userRepository.save(userEntity);
        response.setStatus(HttpServletResponse.SC_OK);
        return "User saved";

    }

    @Override
    public String userLogin(User user,
                            HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        if(authCheck(request)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return "You already authorized";
        }

        if(userRepository.existsByUserLogin(user.getUserLogin())) {
            if (userRepository.existsByUserLoginAndUserPassword(user.getUserLogin(), user.getUserPassword())) {
                request.getSession().setAttribute("isAuthenticated", true);
                response.setStatus(HttpServletResponse.SC_OK);
                return "Hello, "+user.getUserLogin();
            }
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return "Wrong Password";
        }

        response.setStatus(HttpServletResponse.SC_CONFLICT);
        return "User not exsist";
    }

    @Override
    public String userLogOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(authCheck(request)) {
            request.getSession().setAttribute("isAuthenticated",false);
            response.setStatus(HttpServletResponse.SC_OK);
            return "You logout succsesfuly";
        }
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return "You not authorized";
    }

    @Override
    public List<UserEntity> showAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(authCheck(request)) {
            return userRepository.findAll();
       }
        response.getWriter().println("Not Authorized!");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return null;
    }

    public boolean authCheck(HttpServletRequest request){
        HttpSession session = request.getSession();
        Boolean isAuthenticated = (Boolean) session.getAttribute("isAuthenticated");
        if (isAuthenticated == null) {
            isAuthenticated = false;
        }
        return isAuthenticated;
    }
}
