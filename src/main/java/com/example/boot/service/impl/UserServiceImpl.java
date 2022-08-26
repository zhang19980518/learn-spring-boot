package com.example.boot.service.impl;

import com.example.boot.dao.UserDao;
import com.example.boot.entity.User;
import com.example.boot.mapper.UserMapper;
import com.example.boot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userDao;

    @Override
    public Flux<User> getList() {

        Flux<User> userFlux = userDao.selectMany();
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
