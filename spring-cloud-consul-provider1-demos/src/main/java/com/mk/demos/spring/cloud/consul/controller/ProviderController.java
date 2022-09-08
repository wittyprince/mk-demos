package com.mk.demos.spring.cloud.consul.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller
 *
 * @author WangChen
 * Created on 2022/9/8
 * @since 1.0
 */
@RestController
public class ProviderController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello consul";
    }
}
