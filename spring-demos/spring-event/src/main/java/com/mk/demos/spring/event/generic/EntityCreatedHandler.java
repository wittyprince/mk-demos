package com.mk.demos.spring.event.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

/**
 * EntityCreated 处理器handler
 *
 * @author WangChen
 * Created on 2021/4/16 20:02
 * @since 1.0
 */
public class EntityCreatedHandler {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void handleEntityCreatedEvent(EntityCreatedEvent event){
        publisher.publishEvent(event);
    }
}
