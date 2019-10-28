package com.mk.demos.spring.boot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.mk.demos.spring.boot.annotation.ApiVersion;
import com.mk.demos.spring.boot.vo.UserVO;

/**
 * test
 *
 * @author WangChen
 * Created on 2019/10/24 17:10
 * @since 1.0
 */
@RestController
public class TestController {

    @Autowired
    WebApplicationContext context;

    @GetMapping("/test")
    @ResponseBody
    @ApiVersion("1.0")
    public String test1(){
        System.out.println("test1");
        return "test1";
    }

    @GetMapping("/test")
    @ResponseBody
    @ApiVersion("1.1")
    public String test1_1(){
        System.out.println("test1_1");
        return "test1_1";
    }

    @GetMapping("/test")
    @ResponseBody
    @ApiVersion("2.0")
    public String test2(){
        System.out.println("test2");
        return "test2";
    }

    @RequestMapping("/test")
    @ResponseBody
    @ApiVersion("5.0")
    public String test5(){
        System.out.println("test5");
        return "test5";
    }

    @RequestMapping("/test3")
    @ResponseBody
    public String test3(){
        System.out.println("test3");

        RequestMappingHandlerMapping mapping = context.getBean(RequestMappingHandlerMapping.class);
        // 获取url与类和方法的对应信息
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        System.out.println(map);
        return "test3";
    }

    @PostMapping("/post")
    @ApiVersion("1.5")
    public String post1_5(@RequestBody UserVO userVO){
        System.out.println(userVO);
        System.out.println("post1.5");
        return "post1_5";
    }

    @PostMapping("/post")
    @ApiVersion("1.6")
    public String post1_6(UserVO userVO){
        System.out.println(userVO);
        System.out.println("post1.6");
        return "post1_6";
    }
}
