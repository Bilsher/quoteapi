package com.example.quotesender.service;

import com.example.quotesender.model.User;
import com.example.quotesender.model.UserEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public interface UserService {

    public String  userRegistration(User user, HttpServletRequest request,HttpServletResponse response) throws IOException;

    public List<UserEntity> showAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException;

    public String  userLogin(User user, HttpServletRequest request,HttpServletResponse response) throws IOException;

    public String userLogOut(HttpServletRequest request, HttpServletResponse response) throws  IOException;
}
