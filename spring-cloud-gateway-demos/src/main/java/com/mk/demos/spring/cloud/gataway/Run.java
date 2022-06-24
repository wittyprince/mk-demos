package com.mk.demos.spring.cloud.gataway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Predicate;

/**
 * starter class
 *
 * @author WangChen
 * Created on 2022/6/24
 * @since 1.0.0
 */
@SpringBootApplication
@Slf4j
public class Run {

    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }

    /**
     * 用于readBody断言，可配置到yml
     */
    @Bean
    public Predicate<Boolean> bodyPredicate(){
        return new Predicate() {
            @Override
            public boolean test(Object o) {
                log.info("o:{}", o);
                return true;
            }
        };
    }

}
