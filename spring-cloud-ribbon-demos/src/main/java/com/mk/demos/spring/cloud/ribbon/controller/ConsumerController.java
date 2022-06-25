package com.mk.demos.spring.cloud.ribbon.controller;

import com.mk.demos.spring.cloud.ribbon.template.ConsumerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * consumer
 *
 * @author WangChen
 * Created on 2022/6/24
 * @since 1.0.0
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerTemplate consumerTemplate;

    @GetMapping("/consume")
    @ResponseBody
    public String consume() {
        String consume = consumerTemplate.consume();
        return "consume..." + consume;
    }
}
