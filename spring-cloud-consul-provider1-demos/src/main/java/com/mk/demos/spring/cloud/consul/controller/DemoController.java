package com.mk.demos.spring.cloud.consul.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo controller
 *
 * @author WangChen
 * Created on 2022/9/16
 * @since 1.0
 */
@RestController
public class DemoController {

    @RequestMapping("/demo")
    public String demo() {
        return "demo consul";
    }
}
