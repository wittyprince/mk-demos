package com.mk.demos.spring.annotation;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mk.demos.spring.annotation.dao.RoleDAO;
import com.mk.demos.spring.annotation.dao.UserDAO;
import com.mk.demos.spring.annotation.model.User;
import com.mk.demos.spring.annotation.service.RoleService;
import com.mk.demos.spring.annotation.service.UserService;

/**
 * Spring AOP test
 *
 * @author WangChen
 * Created on 2021/1/17 20:14
 * @since 1.0
 */
public class AopTest {

    private UserService userService;
    ApplicationContext applicationContext;

    @Before
    public void before(){
        String configLocation = "classpath:/spring-aop-context.xml";
        applicationContext = new ClassPathXmlApplicationContext(configLocation);
        userService = applicationContext.getBean(UserService.class);
    }

    @Test
    public void test(){

        UserDAO userDAO = applicationContext.getBean(UserDAO.class);
        RoleDAO roleDAO = applicationContext.getBean(RoleDAO.class);
        // 由于UserDAO没有实现接口，所以其代理为由CGLib产生
        System.out.println(userDAO.getClass().getName());// com.mk.demos.spring.annotation.dao.UserDAO$$EnhancerBySpringCGLIB$$87d176ce
        // 由于RoleDAO实现了接口，所以其代理为由Java Proxy产生
        System.out.println(roleDAO.getClass().getName());// com.sun.proxy.$Proxy24
        userService.add(new User());
    }
}
