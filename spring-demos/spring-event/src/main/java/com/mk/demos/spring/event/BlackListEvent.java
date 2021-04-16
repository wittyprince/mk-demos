package com.mk.demos.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义一个ApplicationEvent事件
 *
 * @author WangChen
 * Created on 2021/4/16 13:26
 * @since 1.0
 */
public class BlackListEvent extends ApplicationEvent {

    private final String address;
    private final String content;

    public BlackListEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }

    // accessor and other methods...
}
