package com.example.quotesender.controller;

import com.example.quotesender.dto.Quote;
import com.example.quotesender.model.UserQuote;
import com.example.quotesender.service.UserQuoteServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/quotes")
public class UserQuoteController {

    @Autowired
    private UserQuoteServiceImp userQuoteService;

    @GetMapping("/all")
    public List<UserQuote> getAllQuotes(){
        return userQuoteService.showAllQuotes();
    }

    @PostMapping("/{quoteId}/like")
    public String likeQuote(@PathVariable int quoteId) {
        return userQuoteService.likeQuote(quoteId);
    }

    @PostMapping("/{quoteId}/dislike")
    public String dislikeQuote(@PathVariable int quoteId) {
        return userQuoteService.dislikeQuote(quoteId);
    }

    @GetMapping("/top")
    public List<UserQuote> getTopQuotes() {
        return userQuoteService.getTopRatedQuotes();
    }

    @PostMapping("/add")
    public String postQuote(@RequestBody Quote quote,
                            HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        return userQuoteService.addQuote(quote, request, response);
    }

    @DeleteMapping("/{quoteId}/delete")
    public String deleteQuote(@PathVariable int quoteId){return userQuoteService.deleteQuote(quoteId);}
}