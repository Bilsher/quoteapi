package com.example.quotesender.service;
import com.example.quotesender.model.User;
import com.example.quotesender.model.UserQuote;
import java.util.List;

public interface UserQuoteService {
    public List<UserQuote> showAllQuotes();

    public String deleteQuote(int id);

    public String addQuote();
}
