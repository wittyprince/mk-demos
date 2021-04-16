package com.mk.demos.spring.event.annotation;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 事件发布器
 *
 * @author WangChen
 * Created on 2021/4/16 16:53
 * @since 1.0
 */
@Component
public class BlackListEventPublisher implements ApplicationEventPublisherAware, ApplicationEventPublisher {

    private ApplicationEventPublisher eventPublisher;

    /**
     * At configuration time, the Spring container will
     * detect that EmailService implements ApplicationEventPublisherAware
     * and will automatically call setApplicationEventPublisher().
     * In reality, the parameter passed in will be the Spring container itself;
     * you’re simply interacting with the application context
     * via its ApplicationEventPublisher interface.
     * <p>
     * 实现 *Aware接口实现自动注入原理：
     * 实现 *Aware接口的class bean，spring容器会自动call调用setXXX方法，
     * 然后把spring容器自身当成参数传过去
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.eventPublisher = publisher;
    }


    @Override
    public void publishEvent(ApplicationEvent event) {
        this.eventPublisher.publishEvent(event);
    }

    @Override
    public void publishEvent(Object event) {
        throw new RuntimeException("not support");
    }
}
