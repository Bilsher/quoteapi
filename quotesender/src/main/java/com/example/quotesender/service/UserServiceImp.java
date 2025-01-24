package com.example.quotesender.service;

import com.example.quotesender.model.User;
import com.example.quotesender.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository UserRepository;

    @Override
    public String userRegistration(User user) {
        if (UserRepository.existsByUserLogin(user.getUserLogin()))
            return "this login already taken";
        else {
            UserRepository.save(user);
            return "User saved";
        }
    }

    @Override
    public String userLogin(User user) {
        if(UserRepository.existsByUserLogin(user.getUserLogin())) {
            if (UserRepository.existsByUserLoginAndUserPassword(user.getUserLogin(), user.getUserPassword()))
                return "Hello, "+user.getUserLogin();
            return "Wrong Password";
        }
        return "User not exsist";
    }

    @Override
    public List<User> showAllUsers() {
       return UserRepository.findAll();
    }


}
