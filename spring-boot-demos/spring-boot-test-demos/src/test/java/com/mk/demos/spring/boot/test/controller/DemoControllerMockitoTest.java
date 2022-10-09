package com.mk.demos.spring.boot.test.controller;

import com.mk.demos.spring.boot.test.service.DemoService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * demo controller mockito test
 *
 * @author WangChen
 * Created on 2022/10/9
 * @since 1.0
 */
@SpringBootTest
@AutoConfigureMockMvc
public class DemoControllerMockitoTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DemoService demoService;

    @Test
    public void testHello() throws Exception {
        String name = "wc";
        String expect = "HI: " + name;
        //Mockito
        demoServiceMockBean(name);

        mockMvc.perform(MockMvcRequestBuilders.get("/demo/hello").param("name", "wc"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expect));
    }

    /**
     * Mockito模拟挡板(打桩)
     */
    private void demoServiceMockBean(String name) {
        BDDMockito.given(demoService.hello(name)).willReturn("HI: " + name);
    }
}
