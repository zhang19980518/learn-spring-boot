package com.example.boot.user.service.impl;

import com.example.boot.user.entity.User;
import com.example.boot.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public List<User> getList() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public User getById(Integer id) {
        return new User();
    }

    @Override
    public User saveUser(User user) {
        return new User();
    }
}
