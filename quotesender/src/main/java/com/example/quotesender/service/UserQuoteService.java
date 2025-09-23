package com.example.quotesender.service;
import com.example.quotesender.dto.Quote;
import com.example.quotesender.model.UserQuote;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface UserQuoteService {
    public List<UserQuote> showAllQuotes();
    public String deleteQuote(int id);
    public String addQuote(Quote quote, HttpServletRequest request, HttpServletResponse response);
    public List<UserQuote> getTopRatedQuotes();
    public String likeQuote(int quoteId);
    public String dislikeQuote(int quoteId);
}
