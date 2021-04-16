package com.mk.demos.spring.event.annotation;

import org.springframework.context.ApplicationEvent;

/**
 * 定义事件
 *
 * @author WangChen
 * Created on 2021/4/16 16:41
 * @since 1.0
 */
public class BlackListUpdateEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public BlackListUpdateEvent(Object source) {
        super(source);
    }
}
