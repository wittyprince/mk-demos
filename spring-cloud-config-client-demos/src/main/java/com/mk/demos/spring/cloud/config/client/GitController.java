package com.mk.demos.spring.cloud.config.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GitController
 *
 * @author WangChen
 * Created on 2022/9/9
 * @since 1.0
 */
@RestController
// @RefreshScope 来实现自动刷新
@RefreshScope
public class GitController {

    @Autowired
    private GitConfig gitConfig;

    @Autowired
    private GitAutoRefreshConfig gitAutoRefreshConfig;

    @org.springframework.beans.factory.annotation.
            Value("${data.env:fff}")
    private String env; // 此处使用 @Value 也可以自动刷新

    @GetMapping(value = "getEnv")
    public Object getEnv(){
        return env;
    }

    @GetMapping(value = "show")
    public Object show(){
        return gitConfig;
    }

    @GetMapping(value = "autoShow")
    public Object autoShow(){
        return gitAutoRefreshConfig;
    }
}
