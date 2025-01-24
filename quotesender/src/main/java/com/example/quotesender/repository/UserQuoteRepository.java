package com.example.quotesender.repository;

import com.example.quotesender.model.User;
import com.example.quotesender.model.UserQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserQuoteRepository extends JpaRepository<UserQuote, Integer> {

    public List<UserQuote> findAllByOrderByLikesDesc();

}
