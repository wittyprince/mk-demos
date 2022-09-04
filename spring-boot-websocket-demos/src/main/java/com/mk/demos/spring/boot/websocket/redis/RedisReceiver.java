package com.mk.demos.spring.boot.websocket.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * redis receiver
 *
 * @author WangChen
 * Created on 2022/9/4
 * @since 1.0
 */
@Slf4j
@Component
public class RedisReceiver implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {

        String channel = new String(message.getChannel());// 订阅的频道名称
        String msg = new String(message.getBody(), StandardCharsets.UTF_8);//注意与发布消息编码一致，否则会乱码

        log.info("channel:[{}], msg:[{}]", channel, msg);

    }
}
