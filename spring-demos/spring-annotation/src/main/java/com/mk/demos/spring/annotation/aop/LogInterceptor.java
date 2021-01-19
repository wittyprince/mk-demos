package com.mk.demos.spring.annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志拦截器
 *
 * @author WangChen
 * Created on 2021/1/17 21:54
 * @since 1.0
 */
@Aspect
public class LogInterceptor {

    @Pointcut("execution( * com.mk.demos.spring.annotation.dao..*(..))")
    public void anyDAOMethod(){};

    @Before("execution(public void com.mk.demos.spring.annotation.dao.UserDAO.save(com.mk.demos.spring.annotation.model.User))")
    public void before1() {
        System.out.println("LogInterceptor before1...");
    }

    @Before("anyDAOMethod()")
    public void before() {
        System.out.println("LogInterceptor before...");
    }

    @AfterReturning("anyDAOMethod()")
    public void afterReturning() {
        System.out.println("LogInterceptor after returning...");
    }

    @After("anyDAOMethod()")
    public void after() {
        System.out.println("LogInterceptor after...");
    }

//    @Around("execution()")
    public void around(ProceedingJoinPoint pjp){

    }
}
