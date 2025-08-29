package com.example.quotesender.service;

import com.example.quotesender.model.User;
import com.example.quotesender.model.UserQuote;
import com.example.quotesender.repository.UserQuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuoteServiceImp implements UserQuoteService {

    @Autowired
    private UserQuoteRepository UserQuoteRepository;

    @Override
    public List<UserQuote> showAllQuotes() {
        return UserQuoteRepository.findAll();
    }

    @Override
    public String deleteQuote(int id) {
        return null;
    }

    @Override
    public String addQuote() {
        return null;
    }
}
