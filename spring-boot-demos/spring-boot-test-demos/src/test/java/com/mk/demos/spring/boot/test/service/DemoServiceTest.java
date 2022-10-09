package com.mk.demos.spring.boot.test.service;

import com.mk.demos.spring.boot.test.TestStarterTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class DemoServiceTest extends TestStarterTests {

    @Autowired
    private DemoService demoService;

    @Test
    public void testDemo() {
        String expect = "HELLO";
        String actual = demoService.hello();
        assertEquals(expect, actual);
    }
}