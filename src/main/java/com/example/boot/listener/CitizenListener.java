package com.example.boot.listener;


import com.alibaba.fastjson2.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Slf4j
@Component
@RabbitListener(queues = {"pedestal_citizen"},ackMode = "MANUAL")
public class CitizenListener {

    @RabbitHandler
    public void opHandler(String customTag,byte[] body) {
        System.out.println(customTag);
        //todo 消费消息插入日志   记录消费成功  消费消息根据deliveryTag校验是否重复消费
        String s = new String(body, StandardCharsets.UTF_8);
        JSONArray objects = JSONArray.of(s);
        objects.forEach(System.out::println);
    }
}
