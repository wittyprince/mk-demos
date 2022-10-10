package com.mk.demos.spring.boot.rabbitmq.consumer.receiver;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * receiver
 *
 * @author WangChen
 * Created on 2022/10/10
 * @since 1.0
 */
@Component
public class DirectReceiver {

    @RabbitListener(queues = "direct.queue.1") // direct.queue.1
    public void receiveDirect1(String msg) {
        System.out.println("接收到direct.queue.1的消息：" + msg);
    }

    @RabbitListener(queues = "direct.queue.2") // direct.queue.2
    public void receiveDirect2(Message message, Channel channel) {
        System.out.println("接收到direct.queue.2的消息：" + message + "channel:" + channel);
    }
}
