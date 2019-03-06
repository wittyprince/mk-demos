package com.mk.demo.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mk.demo.mybatis.mapper.UserMapper;

/**
 * 启动类
 * Created by WangChen on 2019/1/27 20:19.
 */
@MapperScan(basePackages = "com.mk.demo.mybatis.mapper")
//@SpringBootConfiguration
@SpringBootApplication
public class Main {
    public static void main(String [] args){
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        System.out.println(context.getBean(UserMapper.class));

    }
}
