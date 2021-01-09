package com.mk.demos.spring.simulation;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.mk.demos.spring.simulation.factory.BeanFactory;
import com.mk.demos.spring.simulation.service.UserService;
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

    private BeanFactory beanFactory;

    @Before
    public void before() throws SAXException, IllegalAccessException, IOException, InstantiationException, InvocationTargetException, ParserConfigurationException, NoSuchMethodException, ClassNotFoundException {
        beanFactory = new ClassPathXmlApplicationContext("src/main/resources/simulation-context.xml");
    }
    @Test
    public void testAdd(){

        userService = (UserService) beanFactory.getBean("userService");

        User user = new User();
        // 这里需要注意的是，传统编程模式里，UserService中UserDAO硬编码时已经初始化(UserDAO userDAO = new UserDAOImpl();)
        // 在模拟Spring中，这里UserDAO还未初始化，直接调用会报NullPointerException
        // 需要把UserDAO装配进来
        userService.add(user);
    }
}
