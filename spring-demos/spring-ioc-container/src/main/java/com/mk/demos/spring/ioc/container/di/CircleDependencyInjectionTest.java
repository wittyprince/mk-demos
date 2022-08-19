package com.mk.demos.spring.ioc.container.di;

import com.mk.demos.spring.ioc.container.di.model.A;
import com.mk.demos.spring.ioc.container.di.model.B;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 循环依赖
 *
 * @author WangChen
 * Created on 2022/8/18
 * @since 1.0
 */
public class CircleDependencyInjectionTest {

    public static void main(String[] args) {
        String basePackage = "com.mk.demos.spring.ioc.container.di.model";
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(basePackage);
//        context.refresh();

//        Spring 在创建 Bean 的时候默认是按照自然排序来进行创建的，所以第一步 Spring 会去创建 A。
//        A a = context.getBean(A.class);
//        B b = context.getBean(B.class);
//        System.out.println("a..." + a);
//        System.out.println("b..." + b);

    }

}
