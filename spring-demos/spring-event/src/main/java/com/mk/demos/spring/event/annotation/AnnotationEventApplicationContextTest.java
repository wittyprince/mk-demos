package com.mk.demos.spring.event.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mk.demos.spring.event.EmailService;

/**
 * 基于注解的事件 示例
 *
 * @author WangChen
 * Created on 2021/4/16 16:47
 * @since 1.0
 */
public class AnnotationEventApplicationContextTest {

    public static void main(String [] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EventConfig.class);
        context.refresh();
        EmailService emailService = context.getBean("emailService", EmailService.class);
        emailService.sendEmail("mk@mk.com", "mkkk");
        emailService.sendEmail("known.hacker@example.org", "known.hacker");
        context.close();
    }
}
