package com.cake.service.impl;

import com.cake.config.RabbitMQConfig;
import com.cake.dto.OrdersCancelDTO;
import com.cake.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j

public class OrderMQService {

    @Autowired
    private  RabbitTemplate rabbitTemplate;
    @Autowired
    @Lazy
    private  OrderService orderService;





    // 发送订单消息到延迟队列
    public void sendOrderDelayMessage(Long orderId, long delayTime) {
        log.info("当前时间：{}", LocalDateTime.now());
        rabbitTemplate.convertAndSend(RabbitMQConfig.DELAY_EXCHANGE, RabbitMQConfig.ROUTING_KEY, orderId, message -> {
            // 设置消息TTL（毫秒）
            message.getMessageProperties().setExpiration(String.valueOf(delayTime));
            return message;
        });
    }

    // 消费死信队列消息（处理超时订单）
    @RabbitListener(queues = RabbitMQConfig.DEAD_LETTER_QUEUE)
    public void handleExpiredOrder(Long orderId) {
        log.info("取消时间：{}",LocalDateTime.now());
        try {
            OrdersCancelDTO ordersCancelDTO = new OrdersCancelDTO();
            ordersCancelDTO.setId(orderId);

            // 处理超时订单
            orderService.cancelOrder(ordersCancelDTO);
        } catch (Exception e) {
            log.error("处理超时订单失败: {}", orderId, e);
            // 可添加重试机制或补偿逻辑
        }
    }
}

