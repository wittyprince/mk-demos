package com.mk.demo.activiti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 启动类
 *
 * @author WangChen
 * Created on 2019/2/18 16:18
 * @since 1.0
 */
@SpringBootApplication
public class Starter {

    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(Starter.class, args);

    }
}
