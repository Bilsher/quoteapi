package com.example.quotesender.model;

import jakarta.persistence.*;


import static jakarta.persistence.GenerationType.IDENTITY;
public class User {
    private int userID;

    private String userLogin;

    private String userPassword;

    public User(){}

    public User(String userLogin,String userPassword){
        this.userLogin=userLogin;
        this.userPassword=userPassword;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


}
