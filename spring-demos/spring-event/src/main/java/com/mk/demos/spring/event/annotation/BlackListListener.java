package com.mk.demos.spring.event.annotation;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.mk.demos.spring.event.BlackListEvent;

/**
 * 事件监听器
 *
 * @author WangChen
 * Created on 2021/4/16 16:45
 * @since 1.0
 */
@Component
public class BlackListListener {

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @EventListener
    public void processBlackListEvent(BlackListEvent event) {
        // notify appropriate parties via notificationAddress...
        System.out.println("@EventListener:" + event);
    }

    @EventListener
    public void processBlackListEvent2(BlackListEvent event) {
        // notify appropriate parties via notificationAddress...
        System.out.println("@EventListener2:" + event);
    }
}
