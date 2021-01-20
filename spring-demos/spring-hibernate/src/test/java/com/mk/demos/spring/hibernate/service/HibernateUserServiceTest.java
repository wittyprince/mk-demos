package com.mk.demos.spring.hibernate.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mk.demos.spring.hibernate.model.HibernateUser;

/**
 * HibernateUserService test
 *
 * @author WangChen
 * Created on 2021/1/20 17:07
 * @since 1.0
 */
public class HibernateUserServiceTest {

    private HibernateUserService hibernateUserService;

    ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:/spring-hibernate-context.xml");
        hibernateUserService = (HibernateUserService) applicationContext.getBean("hibernateUserService");
    }

    @Test
    public void testAdd() {
        HibernateUser user = new HibernateUser();
        user.setName("hibernate_mk");
        hibernateUserService.add(user);
    }

    @Test
    public void testModify(){
        HibernateUser user = new HibernateUser();
        user.setId(1L);
        user.setName("hibernate");
        hibernateUserService.modifyUser(user);
    }

    @Test
    public void testNestedOop(){
        HibernateUser user = new HibernateUser();
        user.setId(1L);
        user.setName("hibernate");
        hibernateUserService.nestedOop(user);
    }
}
