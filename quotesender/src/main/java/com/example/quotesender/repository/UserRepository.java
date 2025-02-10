package com.example.quotesender.repository;

import com.example.quotesender.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>{

    Boolean existsByUserLogin(String login);

    Boolean existsByUserLoginAndUserPassword(String login, String password);

}
