package com.mk.demos.spring.i18n;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ResourceBundleMessageSource test
 * 消息源
 *
 * @author WangChen
 * Created on 2021/4/15 19:44
 * @since 1.0
 */
public class ResourceBundleMessageSourceTest {

    public static void main(String[] args) {
        String configLocation = "META-INF/application-context.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        MessageSource messageSource = context;
        String message = messageSource.getMessage("message", null, "Default", Locale.CHINA);
        System.out.println(message);//Alligators rock!
        String defaultMsg = messageSource.getMessage("xxx", null, "Default", null);
        System.out.println(defaultMsg);//Default

        MyMessageSource myMessageSource = context.getBean("myMessageSource", MyMessageSource.class);
        String message2 = myMessageSource.getMessageSource().getMessage("argument.required", new Object[]{"userDao"},
                "Required", Locale.CHINA);
        System.out.println(message2);
    }


}
