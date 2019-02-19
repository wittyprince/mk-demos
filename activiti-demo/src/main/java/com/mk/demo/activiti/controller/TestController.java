package com.mk.demo.activiti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangChen
 * Created on 2019/2/18 18:37
 * @since
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public void test(){
        System.out.println("ssss");
    }
}
