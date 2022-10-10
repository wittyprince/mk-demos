package com.mk.demos.spring.boot.rabbitmq.producer.service;

/**
 * service
 *
 * @author WangChen
 * Created on 2022/10/10
 * @since 1.0
 */
public interface DirectSendService {

    void sendQueue1(String msg);

    void sendQueue2(String msg);
}
