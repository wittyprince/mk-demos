package com.mk.demos.spring.boot.test.controller;

import com.mk.demos.spring.boot.test.TestStarterTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class DemoControllerTest extends TestStarterTests {

    @Autowired
    private DemoController demoController;

    /**
     * 这只是普通方法调用，并不能模拟http方式调用；
     * 如果想模拟http方式调用，可以使用Spring Test 自带的 MockMvc
     */
    @Test
    public void testHello() {
        String name = "wc";
        String expect = "HELLO: " + name;
        String actual = demoController.hello(name);
        Assertions.assertEquals(expect, actual);
    }

}