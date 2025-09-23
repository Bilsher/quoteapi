package com.example.quotesender.service;

import com.example.quotesender.dto.Quote;
import com.example.quotesender.model.*;
import com.example.quotesender.repository.UserQuoteRepository;
import com.example.quotesender.repository.UserVoteRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQuoteServiceImp implements UserQuoteService {

    @Autowired
    private UserQuoteRepository userQuoteRepository;

    @Autowired
    private UserVoteRepository userVoteRepository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public String likeQuote(int quoteId) {
        Integer userId = getAuthenticatedUserId();
        if (userId == null) {
            return "User not authenticated";
        }
        //Ищем цитату по ID. Если не находим - возвращаем ошибку.
        Optional<UserQuote> optionalQuote = userQuoteRepository.findById(quoteId);
        if (optionalQuote.isEmpty()) {
            return "Quote not found";
        }
        // Достаем найденную цитату и ищем существующий голос этого пользователя для этой цитаты.
        UserQuote quote = optionalQuote.get();
        Optional<UserVote> existingVote = userVoteRepository.findByUserIdAndQuoteId(userId, quoteId);
        if (existingVote.isPresent()) {
            UserVote vote = existingVote.get();
            if ("LIKE".equals(vote.getVoteType())) {
                quote.setLikes(quote.getLikes() - 1);
                userVoteRepository.delete(vote);
                userQuoteRepository.save(quote);
                return "Like removed";
            } else {
                quote.setDislikes(quote.getDislikes() - 1);
                quote.setLikes(quote.getLikes() + 1);
                vote.setVoteType("LIKE");
                userVoteRepository.save(vote);
                userQuoteRepository.save(quote);
                return "Changed dislike to like";
            }
        } else {
            quote.setLikes(quote.getLikes() + 1);
            UserVote newVote = new UserVote(userId, quoteId, "LIKE");
            userVoteRepository.save(newVote);
            userQuoteRepository.save(quote);
            return "Quote liked successfully. Total likes: " + quote.getLikes();
        }
    }

    @Override
    public String dislikeQuote(int quoteId) {
        Integer userId = getAuthenticatedUserId();
        if (userId == null) {
            return "User not authenticated";
        }

        Optional<UserQuote> optionalQuote = userQuoteRepository.findById(quoteId);
        if (optionalQuote.isEmpty()) {
            return "Quote not found";
        }

        UserQuote quote = optionalQuote.get();
        Optional<UserVote> existingVote = userVoteRepository.findByUserIdAndQuoteId(userId, quoteId);

        if (existingVote.isPresent()) {
            UserVote vote = existingVote.get();
            if ("DISLIKE".equals(vote.getVoteType())) {
                quote.setDislikes(quote.getDislikes() - 1);
                userVoteRepository.delete(vote);
                userQuoteRepository.save(quote);
                return "Dislike removed";
            } else {
                quote.setLikes(quote.getLikes() - 1);
                quote.setDislikes(quote.getDislikes() + 1);
                vote.setVoteType("DISLIKE");
                userVoteRepository.save(vote);
                userQuoteRepository.save(quote);
                return "Changed like to dislike";
            }
        } else {
            quote.setDislikes(quote.getDislikes() + 1);
            UserVote newVote = new UserVote(userId, quoteId, "DISLIKE");
            userVoteRepository.save(newVote);
            userQuoteRepository.save(quote);
            return "Quote disliked successfully. Total dislikes: " + quote.getDislikes();
        }
    }

    private Integer getAuthenticatedUserId() {
        HttpSession session = request.getSession(false);
        if (session != null && Boolean.TRUE.equals(session.getAttribute("isAuthenticated"))) {
            // Получаем ID пользователя из сессии
            Integer userId = (Integer) session.getAttribute("userId");
            if (userId != null) {
                return userId;
            }
        }
        return null;
    }

    @Override
    public List<UserQuote> showAllQuotes() {
        return userQuoteRepository.findAll();
    }

    @Override
    public String deleteQuote(int quoteId) {
        Integer userId = getAuthenticatedUserId();
        if (userId == null) {
            return "User not authenticated";
        }
        if (userQuoteRepository.existsById(quoteId)) {
            Optional<UserQuote> optionalQuote = userQuoteRepository.findById(quoteId);
            if (optionalQuote.isEmpty()) {
                return "Quote not found";
            }
            UserQuote quote = optionalQuote.get();
            if(quote.getUserID()==userId) {
                userQuoteRepository.deleteById(quoteId);
                return "Quote deleted successfully";
            }else
            {
                return "You cant delete other users quotes";
            }
        }
        return "Quote not found";
    }

    @Override
    public String addQuote(Quote quote,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        Integer userId = getAuthenticatedUserId();
        if (userId == null) {
            return "User not authenticated";
        }
        UserQuote userQuote = new UserQuote();
        userQuote.setUserID(userId);
        userQuote.setQuoteText(quote.getQuoteText());
        userQuoteRepository.save(userQuote);
        return "Quote added successfully";
    }

    @Override
    public List<UserQuote> getTopRatedQuotes() {
        return userQuoteRepository.findAllByOrderByLikesDesc();
    }

}