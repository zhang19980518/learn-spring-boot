package com.example.boot.handler;


import com.example.boot.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class HelloHandler {

    public Mono<ServerResponse> hello(ServerRequest serverRequest) {

        return ServerResponse.ok().bodyValue("hello world");
    }

    public Mono<ServerResponse> login(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(User.class).doOnSuccess(user -> {
            System.out.println(user.toString());
        }).flatMap(ServerResponse.ok()::bodyValue);
    }
}
