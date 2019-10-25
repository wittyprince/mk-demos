package com.mk.demos.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.demos.spring.boot.annotation.ApiVersion;

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
    @ApiVersion(1)
    public String test1(){
        System.out.println("test1");
        return "test1";
    }

    @RequestMapping("/test")
    @ResponseBody
    @ApiVersion(2)
    public String test2(){
        System.out.println("test2");
        return "test2";
    }

    @RequestMapping("/test3")
    @ResponseBody
    public String test3(){
        System.out.println("test3");
        return "test3";
    }
}
