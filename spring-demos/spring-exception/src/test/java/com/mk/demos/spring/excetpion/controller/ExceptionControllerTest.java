package com.mk.demos.spring.excetpion.controller;

import com.mk.demos.spring.exception.controller.ExceptionController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * ExceptionController Test
 *
 * @author WangChen
 * Created on 2024/4/18
 * @since 1.0
 */
//@WebMvcTest
//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration is used to specify the location of the Spring XML configuration file.
// The @ContextConfiguration annotation is used to load the Spring ApplicationContext.
@ContextConfiguration(locations = {"classpath:/spring-context.xml"})
// @WebAppConfiguration is used to declare that the ApplicationContext loaded for the test is a WebApplicationContext.
@WebAppConfiguration
public class ExceptionControllerTest {


//    private ApplicationContext applicationContext;
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void before() {
//        applicationContext = new ClassPathXmlApplicationContext("classpath:/spring-context.xml");
//        mockMvc = applicationContext.getBean(MockMvc.class);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/exception/test"))
                .andExpect(status().isOk());
    }


}
