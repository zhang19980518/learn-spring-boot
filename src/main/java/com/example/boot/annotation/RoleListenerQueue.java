package com.example.boot.annotation;


import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RabbitListener(queues = {"t_role"},ackMode = "MANUAL")
public @interface RoleListenerQueue {
}
