package com.mercadopreso.order.Config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue orderQueue() {
        return QueueBuilder.durable("fernando").build();
    }

    @Bean
    public Exchange orderExchange() {
        return ExchangeBuilder.directExchange("fernando-ex").build();
    }

    @Bean
    public Binding binding(Queue orderQueue, Exchange orderExchange) {
        return BindingBuilder
                .bind(orderQueue)
                .to(orderExchange)
                .with("fernando-rk")
                .noargs();
    }

}
