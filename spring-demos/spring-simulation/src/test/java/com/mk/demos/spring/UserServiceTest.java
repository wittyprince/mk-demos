package com.mk.demos.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mk.demos.spring.service.UserService;
import com.mk.demos.tradition.model.User;

/**
 * UserServiceTest测试类
 *
 * @author WangChen
 * Created on 2021/1/9 14:20
 * @since 1.0
 */
public class UserServiceTest {

    private UserService userService;
    ApplicationContext applicationContext;

    @Before
    public void before(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:/spring-context.xml");
    }

    @Test
    public void testAdd(){
//        userService = applicationContext.getBean(com.mk.demos.spring.service.UserService.class);
        userService = applicationContext.getBean("userService", UserService.class);
        User user = new User();
        // 这里需要注意的是，传统编程模式里，UserService中UserDAO硬编码时已经初始化(UserDAO userDAO = new UserDAOImpl();)
        // 在模拟Spring中，这里UserDAO还未初始化，直接调用会报NullPointerException
        // 需要把UserDAO装配进来
        userService.add(user);
    }
}
