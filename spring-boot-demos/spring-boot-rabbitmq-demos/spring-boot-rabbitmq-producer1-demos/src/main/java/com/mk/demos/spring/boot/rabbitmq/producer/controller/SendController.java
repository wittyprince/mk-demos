package com.mk.demos.spring.boot.rabbitmq.producer.controller;

import com.mk.demos.spring.boot.rabbitmq.producer.service.DirectSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * send controller
 *
 * @author WangChen
 * Created on 2022/10/10
 * @since 1.0
 */
@RestController
@RequestMapping("/direct")
public class SendController {

    @Autowired
    private DirectSendService directSendService;

    @GetMapping("/queue1/{msg}")
    public void sendQueue1(@PathVariable String msg) {
        directSendService.sendQueue1(msg);
    }

    @GetMapping("/queue2/{msg}")
    public void sendQueue2(@PathVariable String msg) {
        directSendService.sendQueue2(msg);
    }
}
