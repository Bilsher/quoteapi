package com.example.quotesender.service;

import com.example.quotesender.model.User;

import java.util.List;

public interface UserService {

    public String userRegistration(User user);

    public List<User> showAllUsers();

    public String userLogin(User user);
}
