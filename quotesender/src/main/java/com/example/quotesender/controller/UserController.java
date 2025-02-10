package com.example.quotesender.controller;

import com.example.quotesender.model.User;
import com.example.quotesender.repository.UserEntity;
import com.example.quotesender.service.UserServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/quotes")
public class UserController {

    @Autowired
    private UserServiceImp userService;

    @PostMapping("/registration")
    public String initRegistration(@RequestBody User user,
                                   HttpServletRequest request,
                                   HttpServletResponse response) throws IOException {
        return userService.userRegistration(user,request,response);
    }

    @PostMapping("/login")
    public String initLogin(@RequestBody User user,
                            HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        return userService.userLogin(user,request,response);
    }

    @PostMapping("/logOut")
    public String initLogOut(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        return userService.userLogOut(request,response);
    }

    @GetMapping("/allUsers")
    public List<UserEntity> showAllUsers(HttpServletRequest request,
                                         HttpServletResponse response) throws IOException {
        return userService.showAllUsers(request,response);
    }


}
