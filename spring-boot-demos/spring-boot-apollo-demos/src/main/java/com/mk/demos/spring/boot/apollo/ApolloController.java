package com.mk.demos.spring.boot.apollo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller
 *
 * @author WangChen
 * Created on 2022/9/18
 * @since 1.0
 */
@RestController
public class ApolloController {

    @Value("${demo.default.message}")
    private String helloMessage;

    @GetMapping("/getApolloConfig")
    public String getApolloConfig() {
        return helloMessage;
    }
}
