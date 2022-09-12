package com.mk.demos.spring.boot.dubbo.consumer.controller;

import com.mk.demos.spring.boot.dubbo.consumer.service.UserServiceImpl;
import com.mk.demos.spring.boot.dubbo.consumer.service.UserServiceImplGRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller
 *
 * @author WangChen
 * Created on 2022/9/11
 * @since 1.0
 */
@RestController
@RequestMapping("/grpc/user")
public class UserControllerGRpc {

    @Autowired
    private UserServiceImplGRpc userService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return userService.hello(name);
    }
}
