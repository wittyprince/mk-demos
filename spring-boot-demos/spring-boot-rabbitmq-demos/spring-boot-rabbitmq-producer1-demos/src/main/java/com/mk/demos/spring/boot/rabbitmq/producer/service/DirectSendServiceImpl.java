package com.mk.demos.spring.boot.rabbitmq.producer.service;

import com.mk.demos.spring.boot.rabbitmq.producer.config.SendConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DirectSendServiceImpl
 *
 * @author WangChen
 * Created on 2022/10/10
 * @since 1.0
 */
@Service
public class DirectSendServiceImpl implements DirectSendService{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendQueue1(String msg) {
        System.out.println("发送到队列1：" + msg);
        rabbitTemplate.convertAndSend(SendConfig.DIRECT_EXCHANGE, SendConfig.DIRECT_ROUTE_KEY_1, msg);
    }

    @Override
    public void sendQueue2(String msg) {
        System.out.println("发送到队列2：" + msg);
        rabbitTemplate.convertAndSend(SendConfig.DIRECT_EXCHANGE, SendConfig.DIRECT_ROUTE_KEY_2, msg);
    }
}
