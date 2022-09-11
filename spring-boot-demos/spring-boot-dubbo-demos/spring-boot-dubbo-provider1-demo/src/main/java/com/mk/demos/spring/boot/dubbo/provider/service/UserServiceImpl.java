package com.mk.demos.spring.boot.dubbo.provider.service;

import com.mk.demos.spring.boot.dubbo.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * user service impl (provider)
 *
 * @author WangChen
 * Created on 2022/9/11
 * @since 1.0
 */
@Slf4j
//@DubboService(version = "1.0")
@DubboService
public class UserServiceImpl implements UserService {

    @Override
    public String hello(String name) {
        log.info("hi...{}", name);
        return "hello..." + name;
    }
}
