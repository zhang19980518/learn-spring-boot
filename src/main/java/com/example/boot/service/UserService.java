package com.example.boot.service;

import com.example.boot.entity.User;

import java.util.List;


public interface UserService {
    List<User> getList();

    User getById(Integer id);

    User saveUser(User user);
}
