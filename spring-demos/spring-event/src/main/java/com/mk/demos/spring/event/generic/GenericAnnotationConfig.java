package com.mk.demos.spring.event.generic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 *
 * @author WangChen
 * Created on 2021/4/16 19:35
 * @since 1.0
 */
@Configuration
public class GenericAnnotationConfig {

    @Bean
    public EntityCreatedListener listener(){
        return new EntityCreatedListener();
    }

    @Bean
    public EntityCreatedHandler handler(){
        return new EntityCreatedHandler();
    }

}
