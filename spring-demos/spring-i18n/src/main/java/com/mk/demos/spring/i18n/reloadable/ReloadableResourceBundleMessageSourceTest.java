package com.mk.demos.spring.i18n.reloadable;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ReloadableResourceBundleMessageSource test
 * 支持热重载
 *
 * @author WangChen
 * Created on 2021/4/15 21:45
 * @since 1.0
 */
public class ReloadableResourceBundleMessageSourceTest {

    public static void main(String [] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ReloadableConfig.class);
        context.refresh();
        MessageSource messageSource = context;

        // 实现hot reload热重载的步骤：
        // 1. 把CacheSeconds设置短一点，如1秒
        // 2. 手动更改target/classes 目录下对应的文件，如messages.properties
        // 3. 邮件选中整个工程，如spring-i18n，选择Maven -> Reload project
        boolean loop = true;
        while (loop){
            String message = messageSource.getMessage("user.welcome", new Object[]{"mk"}, "Default", Locale.CHINA);
            System.out.println(message);//Welcome mk
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        context.close();

    }
}
