package com.example.quotesender.service;

import com.example.quotesender.model.User;
import com.example.quotesender.model.UserEntity;
import com.example.quotesender.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String userRegistration(User user,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws IOException{

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
    public String userLogin(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(userRepository.existsByUserLogin(user.getUserLogin())) {
            if (userRepository.existsByUserLoginAndUserPassword(user.getUserLogin(), user.getUserPassword())) {
                Optional<UserEntity> userEntity = userRepository.findByUserLogin(user.getUserLogin());
                if (userEntity.isPresent()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("isAuthenticated", true);
                    session.setAttribute("userId", userEntity.get().getUserID());
                    session.setAttribute("userLogin", userEntity.get().getUserLogin());
                    response.setStatus(HttpServletResponse.SC_OK);
                    return "Hello, " + user.getUserLogin();
                }
            }
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return "Wrong Password";
        }
        response.setStatus(HttpServletResponse.SC_CONFLICT);
        return "User not exist";
    }

    @Override
    public String userLogOut(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("isAuthenticated");
            session.removeAttribute("userId");
            session.removeAttribute("userLogin");
            session.invalidate();
        }
        return "You logout successfully";
    }

    @Override
    public List<UserEntity> showAllUsers(HttpServletRequest request,
                                         HttpServletResponse response) throws IOException {
        return userRepository.findAll();
    }
}
