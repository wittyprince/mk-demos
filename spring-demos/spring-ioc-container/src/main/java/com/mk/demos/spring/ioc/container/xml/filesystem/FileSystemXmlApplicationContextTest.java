package com.mk.demos.spring.ioc.container.xml.filesystem;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.mk.demos.spring.model.user.Profile;

/**
 * 文件系统的 xml方式 配置 ApplicationContext
 *
 * @author WangChen
 * Created on 2021/4/17 21:38
 * @since 1.0
 */
public class FileSystemXmlApplicationContextTest {

    public static void main(String [] args){
        // 访问本地文件系统的绝对路径
        String configLocation = "D:\\Gitspace\\mk\\mk-demos\\spring-demos\\spring-ioc-container\\src\\main\\resources\\META-INF\\xml-context.xml";
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(configLocation);
        Profile profile = context.getBean(Profile.class);
        System.out.println(profile);
    }
}
