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

    @EventListener
    public BlackListUpdateEvent handleBlackListEvent(BlackListEvent event) {
        // notify appropriate parties via notificationAddress and
        // then publish a ListUpdateEvent...
        return new BlackListUpdateEvent(event.getSource());
    }

    @EventListener
    public void processBlackListUpdateEvent(BlackListUpdateEvent updateEvent){
        System.out.println("BlackListUpdateEvent:" + updateEvent);
    }

    // 监听多个事件
//    @EventListener({ContextStartedEvent.class, ContextRefreshedEvent.class})
//    public void handleContextStart() {
//    ...
//    }

    // SPEL 表达式
//    @EventListener(condition = "#blEvent.content == 'foo'")
//    public void processBlackListEvent(BlackListEvent blEvent) {
//        // notify appropriate parties via notificationAddress...
//    }
}
