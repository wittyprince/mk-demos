package com.mk.demos.spring.cloud.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Run
 *
 * @author WangChen
 * Created on 2022/6/24
 * @since 1.0.0
 */
@SpringBootApplication
@EnableFeignClients
public class Run {

    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }


}
