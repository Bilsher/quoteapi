package com.example.quotesender.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="UsersQuote", schema="UsersQuote")
public class UserQuote {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int quoteID;

    @Column(name="likes")
    private int likes;

    @Column(name="dislikes")
    private int dislikes;

    @Column(name="quoteText")
    private String quoteText;

    private int userID;

    public UserQuote(){}

    public UserQuote(int likes, int dislikes, String quoteText, int userID) {
        this.likes = likes;
        this.dislikes = dislikes;
        this.quoteText = quoteText;
        this.userID = userID;
    }

    public int getQuoteID() {
        return quoteID;
    }

    public void setQuoteID(int quoteID) {
        this.quoteID = quoteID;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
