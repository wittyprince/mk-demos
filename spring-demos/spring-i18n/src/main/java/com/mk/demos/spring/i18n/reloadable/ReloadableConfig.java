package com.mk.demos.spring.i18n.reloadable;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * 配置类
 *
 * @author WangChen
 * Created on 2021/4/15 21:47
 * @since 1.0
 */
@Configuration
public class ReloadableConfig {

    @Bean("messageSource")
    public MessageSource reloadableMessageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        // 方式一：classpath:
        // messageSource.setBasenames("classpath:reloadable/messages");
        // 方式二：直接路径
        // messageSource.setBasenames("/reloadable/messages");
        // 方式三：相对路径
        messageSource.setBasenames("reloadable/messages");
        messageSource.setCacheSeconds(1);
        return messageSource;
    }
}
