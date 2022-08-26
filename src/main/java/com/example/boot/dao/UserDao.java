package com.example.boot.dao;

import com.example.boot.entity.User;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends ReactiveCrudRepository<User,Integer> {
}
