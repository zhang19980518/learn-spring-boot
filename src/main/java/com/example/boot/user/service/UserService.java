package com.example.boot.user.service;

import com.example.boot.user.entity.User;

import java.util.List;


public interface UserService {
    List<User> getList();

    User getById(Integer id);

    User saveUser(User user);
}
