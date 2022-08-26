package com.example.boot.service;

import com.example.boot.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface UserService {
    Flux<User> getList();

    Mono<User> getById(Integer id);

    Mono<User> saveUser(Mono<User> userMono);
}
