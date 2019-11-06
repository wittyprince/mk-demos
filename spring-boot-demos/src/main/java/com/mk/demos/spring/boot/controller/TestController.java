package com.mk.demos.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * test
 *
 * @author WangChen
 * Created on 2019/10/24 17:10
 * @since 1.0
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test1(){
        System.out.println("test1");
        return "test1";
    }

//    @RequestMapping("/test")
//    public void test2(){
//        System.out.println("test2");
//    }
}
