package com.example.quotesender.repository;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="Users", schema="Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int userID;

    @Column(name="login")
    private String userLogin;

    @Column(name="password")
    private String userPassword;

    public UserEntity(){}

    public UserEntity(String userLogin,String userPassword){
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
