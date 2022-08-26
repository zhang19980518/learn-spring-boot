package com.example.boot.listener;


import com.example.boot.config.RabbitConfig;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {RabbitConfig.QUEUE},ackMode = "MANUAL")
@ConditionalOnBean(value = RabbitConfig.class)
public class IOMQListener {

    @RabbitHandler
    public void opHandler(String body, Message message){
        //todo 消费消息插入日志   记录消费成功  消费消息根据deliveryTag校验是否重复消费
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
//        System.out.println(deliveryTag);
//        System.out.println(body);
//        System.out.println(message.toString());
    }
}
