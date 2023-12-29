package com.mk.demos;

import com.mk.demos.mybatis.mapper.UserMapper;
import com.mk.demos.mybatis.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 */
//@MapperScan("com.mk.demos.mybatis")
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
//        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
//        System.out.println(context.getBean(UserMapper.class));
//        UserMapper userMapper = context.getBean(UserMapper.class);
//        User user = userMapper.selectByPrimaryKey(1L).orElse(null);
//        System.out.println(user);
    }
}
