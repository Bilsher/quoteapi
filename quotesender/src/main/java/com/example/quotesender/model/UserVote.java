package com.example.quotesender.model;

import jakarta.persistence.*;
//todo удалить schema
@Entity
@Table(name = "user_votes", schema = "UsersQuote")
public class UserVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id")
    private int voteId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "quote_id", nullable = false)
    private int quoteId;

    @Column(name = "vote_type", nullable = false, length = 10)
    private String voteType;

    public UserVote() {}

    public UserVote(int userId, int quoteId, String voteType) {
        this.userId = userId;
        this.quoteId = quoteId;
        this.voteType = voteType;
    }

    public int getVoteId() { return voteId; }
    public void setVoteId(int voteId) { this.voteId = voteId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getQuoteId() { return quoteId; }
    public void setQuoteId(int quoteId) { this.quoteId = quoteId; }

    public String getVoteType() { return voteType; }
    public void setVoteType(String voteType) { this.voteType = voteType; }
}