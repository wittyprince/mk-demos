package com.mk.demos.spring.event.generic;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * 创建实体 事件
 * 事件可以是任意类型的，不一定必须是ApplicationEvent类型的
 * @author WangChen
 * Created on 2021/4/16 17:49
 * @since 1.0
 */
public class EntityCreatedEvent<T> /*extends ApplicationEvent*/ implements ResolvableTypeProvider {

    private T source;

    public EntityCreatedEvent(T entity) {
//        super(entity);
        this.source = entity;
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(/*getSource()*/ source));
    }
}
