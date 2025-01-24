package com.example.quotesender.controller;

import com.example.quotesender.model.UserQuote;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.quotesender.service.UserQuoteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quotes")
public class UserQuoteController {

    @Autowired
    private UserQuoteServiceImp UserQuoteService;

    @GetMapping("/all")
    public List<UserQuote> getAllQuotes(){
        return UserQuoteService.showAllQuotes();
    }
}
