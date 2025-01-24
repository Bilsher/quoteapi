package com.example.quotesender.controller;

import com.example.quotesender.model.User;
import com.example.quotesender.model.UserQuote;
import com.example.quotesender.repository.UserQuoteRepository;
import com.example.quotesender.repository.UserRepository;
import com.example.quotesender.service.UserService;
import com.example.quotesender.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quotes")
public class MainController {

    @Autowired
    private UserQuoteRepository UserQuoteRepository;
    @Autowired
    private UserRepository UserRepository;

    @GetMapping("/")
    public String homePage(){
        return "hello";
    }

    @GetMapping("/all")
    public List<UserQuote> getAllQuotes(){
        return UserQuoteRepository.findAll();
    }

    @PostMapping("/registration")
    public List<User> initRegistration(@RequestBody User user){
        UserRepository.save(user);
        return UserRepository.findAll();
    }


}
