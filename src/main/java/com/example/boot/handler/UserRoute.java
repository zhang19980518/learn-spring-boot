package com.example.boot.handler;


import com.example.boot.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRoute {

    @Bean(name = "UserRoute")
    public RouterFunction<ServerResponse> route(UserHandler handler){
        return RouterFunctions.route(RequestPredicates.GET("/user"),handler::list)
                .andRoute(RequestPredicates.POST("/user"),handler::save)
                .andRoute(RequestPredicates.GET("/user/{id}"),handler::getById);
    }
}
