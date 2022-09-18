package com.mk.demos.spring.boot.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * apollo
 *
 * @author WangChen
 * Created on 2022/9/18
 * @since 1.0
 */
@SpringBootApplication
@EnableApolloConfig
public class ApolloConfigRun {

    public static void main(String[] args) {
        SpringApplication.run(ApolloConfigRun.class, args);
    }
}
