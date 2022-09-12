package com.mk.demos.spring.boot.dubbo.consumer.service;

import com.mk.demos.spring.boot.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * consumer
 *
 * @author WangChen
 * Created on 2022/9/11
 * @since 1.0
 */
@Service
public class UserServiceImplGRpc {

    @DubboReference(version = "2.0.0", protocol = "dubbo")
    private UserService userService;

    public String hello(String name) {
        return userService.hello(name);
    }
}
