package com.example.quotesender.repository;

import com.example.quotesender.model.UserVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserVoteRepository extends JpaRepository<UserVote, Integer> {

    Optional<UserVote> findByUserIdAndQuoteId(int userId, int quoteId);

    boolean existsByUserIdAndQuoteId(int userId, int quoteId);

    void deleteByUserIdAndQuoteId(int userId, int quoteId);
}