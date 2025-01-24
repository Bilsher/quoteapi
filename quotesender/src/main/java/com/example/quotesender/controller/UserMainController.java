package com.example.quotesender.controller;

import com.example.quotesender.model.User;
import com.example.quotesender.service.UserServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/quotes")
public class UserMainController {

    @Autowired
    private UserServiceImp UserService;

    @PostMapping("/registration")
    public String initRegistration(@RequestBody User user){
        return UserService.userRegistration(user);
    }

    @PostMapping("/login")
    public String initLogin(HttpServletRequest request, @RequestBody User user){
        request.getSession().setAttribute("isAuthenticated", true);
        return UserService.userLogin(user);
    }

    @GetMapping("/allUsers")
    public List<User> showAllUsers(){
        return UserService.showAllUsers();
    }


}
