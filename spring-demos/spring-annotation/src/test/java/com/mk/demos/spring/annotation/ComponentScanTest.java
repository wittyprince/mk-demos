package com.mk.demos.spring.annotation;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mk.demos.spring.annotation.model.Role;
import com.mk.demos.spring.annotation.model.User;
import com.mk.demos.spring.annotation.service.RoleService;
import com.mk.demos.spring.annotation.service.UserService;

/**
 * component scan test
 *
 * @author WangChen
 * Created on 2021/1/10 14:11
 * @since 1.0
 */
public class ComponentScanTest {

//    @Resource
    private RoleService roleService;
    ApplicationContext applicationContext;

    @Before
    public void before(){
        String configLocation = "classpath:/spring-component-scan-context.xml";
        applicationContext = new ClassPathXmlApplicationContext(configLocation);
        roleService = applicationContext.getBean(RoleService.class);
    }

    @Test
    public void test(){
        roleService.add(new Role());
    }
}
