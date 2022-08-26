package com.example.boot.handler;


import com.example.boot.entity.User;
import com.example.boot.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class UserHandler {

    private final UserService service;

    public UserHandler(UserService service) {
        this.service = service;
    }

    public Mono<ServerResponse> list(ServerRequest request){
        return service.getList().collectList().flatMap(ServerResponse.ok()::bodyValue);
    }

    public Mono<ServerResponse> getById(ServerRequest request){
        Integer id = Integer.valueOf(request.pathVariable("id"));
        return service.getById(id).flatMap(ServerResponse.ok()::bodyValue);
    }

    public Mono<ServerResponse> save(ServerRequest request){
        Mono<User> userMono = request.bodyToMono(User.class);

        return service.saveUser(userMono).flatMap(ServerResponse.ok()::bodyValue);
    }
}
