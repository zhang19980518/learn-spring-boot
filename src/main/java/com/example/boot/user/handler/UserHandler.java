package com.example.boot.user.handler;


import com.example.boot.user.entity.User;
import com.example.boot.user.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
@Component
public class UserHandler {

    private final UserService service;

    public UserHandler(UserService service) {
        this.service = service;
    }

    public Mono<ServerResponse> list(ServerRequest request) {
        return ServerResponse.ok().bodyValue(service.getList());
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        Integer id = Integer.valueOf(request.pathVariable("id"));
        return ServerResponse.ok().bodyValue(service.getById(id));
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(User.class).doOnSuccess(service::saveUser).flatMap(ServerResponse.ok()::bodyValue);
    }
}
