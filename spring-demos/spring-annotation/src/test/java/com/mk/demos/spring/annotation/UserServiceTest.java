package com.mk.demos.spring.annotation;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mk.demos.spring.annotation.model.Role;
import com.mk.demos.spring.annotation.model.User;
import com.mk.demos.spring.annotation.service.UserService;

/**
 * UserService Test
 *
 * @author WangChen
 * Created on 2021/1/10 10:59
 * @since 1.0
 */
public class UserServiceTest {

    private UserService userService;
    ApplicationContext applicationContext;

    @Before
    public void before(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:/spring-context.xml");
        userService = applicationContext.getBean(UserService.class);
    }

    @Test
    public void test(){

        userService.add(new User());
        userService.add(new Role());
    }


}
