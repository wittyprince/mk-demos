package com.mk.demos.spring.event;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * event
 *
 * @author WangChen
 * Created on 2021/4/16 13:53
 * @since 1.0
 */
public class EventApplicationContextTest {

    public static void main(String [] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        String location = "META-INF/application-context.xml";
        context.setConfigLocation(location);
        context.refresh();
        EmailService emailService = context.getBean("emailService", EmailService.class);

        emailService.sendEmail("mk@mk.com", "mkkk");

        emailService.sendEmail("known.hacker@example.org", "known.hacker");
        context.close();

    }
}
