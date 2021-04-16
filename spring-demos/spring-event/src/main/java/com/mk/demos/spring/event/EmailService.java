package com.mk.demos.spring.event;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * 用于发布 自定义的 ApplicationEvent 事件
 * 通过publishEvent()方法
 *
 * @author WangChen
 * Created on 2021/4/16 13:27
 * @since 1.0
 */
public class EmailService implements ApplicationEventPublisherAware {

    private List<String> blackList;
    private ApplicationEventPublisher publisher;

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }

    /**
     * At configuration time, the Spring container will
     * detect that EmailService implements ApplicationEventPublisherAware
     * and will automatically call setApplicationEventPublisher().
     * In reality, the parameter passed in will be the Spring container itself;
     * you’re simply interacting with the application context
     * via its ApplicationEventPublisher interface.
     *
     * 实现 *Aware接口实现自动注入原理：
     * 实现 *Aware接口的class bean，spring容器会自动call调用setXXX方法，
     * 然后把spring容器自身当成参数传过去
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void sendEmail(String address, String content) {
        if (blackList.contains(address)) {
            publisher.publishEvent(new BlackListEvent(this, address, content));
            return;
        }
        // send email...
        System.out.println("email was send to : " + address);
    }
}
