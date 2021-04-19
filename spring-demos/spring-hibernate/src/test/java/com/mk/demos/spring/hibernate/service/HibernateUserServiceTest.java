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

    private UserService userService;

    ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new ClassPathXmlApplicationContext("spring-hibernate-context.xml");
        userService = (UserService) applicationContext.getBean("userService");
    }

    @Test
    public void testAdd() {
        HibernateUser user = new HibernateUser();
        user.setName("hibernate_mk");
        System.out.println("save前，userId = " + user.getId());
        userService.add(user);
        System.out.println("save后，userId = " + user.getId());
    }

    @Test
    public void testModify(){
        HibernateUser user = new HibernateUser();
        user.setId(2L);//TODO 当user id 从 1 变为 2 时，报异常 org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException: Object of class [com.mk.demos.spring.hibernate.model.HibernateUser] with identifier [2]: optimistic locking failed; nested exception is org.hibernate.StaleObjectStateException: Row was updated or deleted by another transaction (or unsaved-value mapping was incorrect) : [com.mk.demos.spring.hibernate.model.HibernateUser#2]
        user.setName("u2");
        userService.modifyUser(user);
    }

    @Test
    public void testNestedOop(){
        HibernateUser user = new HibernateUser();
        user.setId(1L);
        user.setName("hibernate");
        userService.nestedOop(user);
    }

    @Test
    public void testHibernateTemplate(){
        HibernateUser user = new HibernateUser();
        user.setId(1L);
        user.setName("template");
//        hibernateUserService.templateAdd(user);
    }

    @Test
    public void testFindById(){
        HibernateUser user = userService.findById(1L);
        System.out.println(user.getClass());
    }
}
