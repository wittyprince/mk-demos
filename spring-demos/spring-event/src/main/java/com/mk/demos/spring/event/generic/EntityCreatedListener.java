package com.mk.demos.spring.event.generic;

import org.springframework.context.event.EventListener;

import com.mk.demos.spring.model.user.User;

/**
 * 创建entity listener
 *
 * @author WangChen
 * Created on 2021/4/16 17:53
 * @since 1.0
 */
public class EntityCreatedListener {

    @EventListener
    public void onUserCreated(EntityCreatedEvent<User> event) {
        System.out.println("onUserCreated:" + event);
    }
}
