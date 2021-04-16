package com.mk.demos.spring.event.annotation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mk.demos.spring.event.BlackListEvent;
import com.mk.demos.spring.event.EmailService;

/**
 * config配置类
 *
 * @author WangChen
 * Created on 2021/4/16 16:48
 * @since 1.0
 */
@Configuration
@ComponentScan(basePackages = "com.mk.demos.spring.event.annotation")
public class EventConfig {

//    public BlackListEvent blackListEvent(){
//        BlackListEvent blackListEvent = new BlackListEvent();
//        return new BlackListEvent()
//    }

    @Bean("emailService")
    public EmailService emailService(){
        EmailService emailService = new EmailService();
        List<String> blackList = new ArrayList<>(3);
        blackList.add("known.spammer@example.org");
        blackList.add("known.hacker@example.org");
        blackList.add("john.doe@example.org");
        emailService.setBlackList(blackList);
        return emailService;
    }

//    @Bean
//    public BlackListEventPublisher eventPublisher(){
//        return new BlackListEventPublisher();
//    }
}
