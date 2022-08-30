package com.example.boot.user.service.impl;

import com.example.boot.user.entity.User;
import com.example.boot.user.mapper.UserMapper;
import com.example.boot.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public List<User> getList() {
        return userMapper.selectList(null);
    }

    @Override
    public User getById(Integer id) {
        return userMapper.selectById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public User saveUser(User user) {
        userMapper.insert(user);
        return user;
    }
}
