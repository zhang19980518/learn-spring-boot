package com.example.boot.service.impl;

import com.example.boot.dao.UserDao;
import com.example.boot.entity.User;
import com.example.boot.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Flux<User> getList() {
        Flux<User> userFlux = userDao.findAll();
        userFlux.count().doOnSuccess(System.out::println);
        return userFlux;
    }

    @Override
    public Mono<User> getById(Integer id) {
        return userDao.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Mono<User> saveUser(Mono<User> user) {
        //todo id自增情况下暂未找到实现方式
        return user.doOnSuccess(userDao::save);
    }
}
