package com.mk.demos.spring.cloud.nacos.discovery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * consumer controller
 *
 * @author WangChen
 * Created on 2022/6/26
 * @since 1.0.0
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private String providerUrl = "http://cloud-discovery-provider/provider/provide";

    private final RestTemplate restTemplate;

    @Autowired
    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    @GetMapping("/consume/{str}")
    public String consume(@PathVariable String str) {
        String forObject = restTemplate.getForObject(providerUrl + "/" + str, String.class);
        return "consume..." + forObject;
    }
}
