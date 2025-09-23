package com.example.quotesender.dto;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;


public class Quote {


    private String quoteText;

    public Quote(){}

    public Quote(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

}
