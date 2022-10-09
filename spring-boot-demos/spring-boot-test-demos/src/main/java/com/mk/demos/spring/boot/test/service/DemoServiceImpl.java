package com.mk.demos.spring.boot.test.service;

import org.springframework.stereotype.Service;

/**
 * demo service impl
 *
 * @author WangChen
 * Created on 2022/10/9
 * @since 1.0
 */
@Service
public class DemoServiceImpl implements DemoService{
    @Override
    public String hello() {
        return "HELLO";
    }
}
