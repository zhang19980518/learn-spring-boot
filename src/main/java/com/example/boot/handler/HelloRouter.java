package com.example.boot.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class HelloRouter {

    @Bean
    public RouterFunction<ServerResponse> route(HelloHandler handler) {
        //定义映射地址与ch处理器方法之前的对应关系
        return RouterFunctions.route(RequestPredicates.GET("/hello"), handler::hello)
                .andRoute(RequestPredicates.POST("/login"), handler::login);
    }
}
