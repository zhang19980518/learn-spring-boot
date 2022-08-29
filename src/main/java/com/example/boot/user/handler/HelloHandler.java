package com.example.boot.user.handler;


import com.example.boot.user.input.QueryDTO;
import com.example.boot.user.entity.UserDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class HelloHandler {

    public Mono<ServerResponse> hello(ServerRequest serverRequest) {

        return ServerResponse.ok().bodyValue("hello world");
    }

    public Mono<ServerResponse> login(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(UserDemo.class).doOnSuccess(userDemo -> {
           log.info("user is:{}", userDemo);
        }).flatMap(ServerResponse.ok()::bodyValue);
    }

    public Mono<ServerResponse> queryByParam(ServerRequest serverRequest) {
        var query=new QueryDTO();
        serverRequest.queryParam("userName").ifPresent(query::setUserName);
        serverRequest.queryParam("name").ifPresent(query::setName);
        return ServerResponse.ok().bodyValue(query);
    }
}
