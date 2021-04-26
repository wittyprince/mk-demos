package com.mk.demos.spring.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 使用代理调用
 *
 * @author WangChen
 * Created on 2021/4/26 19:24
 * @since
 */
public class WithProxyCall {

    public static void main(String[] args) {

        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        // factory.addAdvice(new RetryAdvice());
        factory.addAdvice(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                System.out.println("1: " + methodInvocation.getMethod().getName());
                if ("bar".equals(methodInvocation.getMethod().getName())) {
                    System.out.println("2");
                    return methodInvocation.proceed();
                }
                System.out.println("3");
                return methodInvocation.proceed();
            }
        });

        // 当需要通过AopContext.currentProxy()调用内部方法走AOP代理时，需要设置ExposeProxy=true
        factory.setExposeProxy(true);
        // 当被代理类实现接口时，Spring默认走JDK dynamic proxy
        // 当设置ProxyTargetClass=true时，走的是CGLIB代理
        // factory.setProxyTargetClass(true);

        Pojo pojo = (Pojo) factory.getProxy();

        // this is a method call on the proxy!
        pojo.foo();
    }
}
