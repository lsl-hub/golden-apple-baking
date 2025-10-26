package com.cake.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {
    // 延迟队列交换机
    public static final String DELAY_EXCHANGE = "order.delay.exchange";
    // 延迟队列名称
    public static final String DELAY_QUEUE = "order.delay.queue";
    // 死信交换机
    public static final String DEAD_LETTER_EXCHANGE = "order.deadletter.exchange";
    // 死信队列（实际处理队列）
    public static final String DEAD_LETTER_QUEUE = "order.deadletter.queue";
    // 路由键
    public static final String ROUTING_KEY = "order.cancel";


    // 配置延迟队列
    @Bean
    public DirectExchange delayExchange() {
        return new DirectExchange(DELAY_EXCHANGE);
    }

    // 配置死信队列
    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(DEAD_LETTER_EXCHANGE);
    }

    // 配置延迟队列，设置死信交换机
    @Bean
    public org.springframework.amqp.core.Queue delayQueue() {
        Map<String, Object> args = new HashMap<>();
        // 设置死信交换机
        args.put("x-dead-letter-exchange", DEAD_LETTER_EXCHANGE);
        // 设置死信路由键
        args.put("x-dead-letter-routing-key", ROUTING_KEY);
        return new org.springframework.amqp.core.Queue(DELAY_QUEUE, true, false, false, args);
    }

    // 配置死信队列（实际处理队列）
    @Bean
    public org.springframework.amqp.core.Queue deadLetterQueue() {
        return new Queue(DEAD_LETTER_QUEUE, true);
    }

    // 绑定延迟队列到延迟交换机
    @Bean
    public Binding delayBinding() {
        return BindingBuilder.bind(delayQueue()).to(delayExchange()).with(ROUTING_KEY);
    }

    // 绑定死信队列到死信交换机
    @Bean
    public Binding deadLetterBinding() {
        return BindingBuilder.bind(deadLetterQueue()).to(deadLetterExchange()).with(ROUTING_KEY);
    }
}
