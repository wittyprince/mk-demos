package com.mk.demos.spring.event.generic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mk.demos.spring.model.user.User;

/**
 * 泛型
 * 借助 ResolvableTypeProvider 处理
 *
 * @author WangChen
 * Created on 2021/4/16 19:34
 * @since 1.0
 */
public class GenericAnnotationApplicationContextTest {

    public static void main(String [] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(GenericAnnotationConfig.class);
        context.refresh();
        EntityCreatedHandler handler = context.getBean(EntityCreatedHandler.class);
        handler.handleEntityCreatedEvent(new EntityCreatedEvent<>(new User()));

        context.close();
    }
}
