package com.mk.demos.spring.boot.test.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * demo controller mock mvc test
 *
 * @author WangChen
 * Created on 2022/10/9
 * @since 1.0
 */
@SpringBootTest
@AutoConfigureMockMvc // 开启Mock Mvc测试的自动化配置的
public class DemoControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DemoController demoController;

    @Test
    public void testHello() throws Exception {
        String name = "wc";
        String expect = "HELLO: " + name;
        String actual = demoController.hello(name);
//        Assertions.assertEquals(expect, actual);
        mockMvc.perform(MockMvcRequestBuilders.get("/demo/hello").param("name", "wc"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expect));
    }


}
