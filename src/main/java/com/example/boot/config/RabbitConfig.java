package com.example.boot.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class RabbitConfig {

    public static final String ECHANGE_NAME="io";

    public static final String QUEUE="op";

    @Bean
    public Exchange mm(){
        return ExchangeBuilder.topicExchange(ECHANGE_NAME).durable(true).build();
    }

    @Bean
    public Queue tRole(){
        return QueueBuilder.durable(QUEUE).build();
    }

    @Bean
    public Binding tRoleBinding(Queue queue,Exchange exchange){
      return  BindingBuilder.bind(queue).to(exchange).with("op.#").noargs();
    }

    @Bean
    public RabbitTemplate template(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate=new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory=new SimpleRabbitListenerContainerFactory();
        simpleRabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        simpleRabbitListenerContainerFactory.setMessageConverter(new Jackson2JsonMessageConverter());
        return simpleRabbitListenerContainerFactory;
    }
}
