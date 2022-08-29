package com.example.boot.user.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

/**
 * //todo 注意 pathVariable路径需要放在哪最后
 */
@Configuration
public class HelloRouter {

    @Bean
    public RouterFunction<ServerResponse> route(HelloHandler handler) {
        //定义映射地址与ch处理器方法之前的对应关系
        return RouterFunctions.route(RequestPredicates.GET("/hello"), handler::hello)
                .andRoute(RequestPredicates.POST("/login"), handler::login)
                .andRoute(RequestPredicates.GET("/query"),handler::queryByParam)
                ;
    }
}
