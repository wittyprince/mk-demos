package com.mk.demos.spring.aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;

/**
 * @author WangChen
 * Created on 2021/4/26 19:25
 * @since
 */
public class RetryAdvice implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("1");
        if (!"hello".equals(methodInvocation.getMethod().getName())) {
            System.out.println("2");
            return methodInvocation.proceed();
        }
        System.out.println("3");
        return "elin, " + methodInvocation.proceed() + "!";
    }
}
