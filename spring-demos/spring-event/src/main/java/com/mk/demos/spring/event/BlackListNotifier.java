package com.mk.demos.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * 用于接受自定义的ApplicationEvent事件
 *
 * @author WangChen
 * Created on 2021/4/16 13:40
 * @since 1.0
 */
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(BlackListEvent event) {
        // notify appropriate parties via notificationAddress...
        System.out.println(event);
    }
}
