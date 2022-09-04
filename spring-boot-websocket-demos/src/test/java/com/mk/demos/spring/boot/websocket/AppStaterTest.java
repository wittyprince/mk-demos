package com.mk.demos.spring.boot.websocket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * spring boot test
 *
 * @author WangChen
 * Created on 2022/9/4
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppStaterTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1() {
        DemoBO demoBO = new DemoBO(123L, "wangchen");
        redisTemplate.opsForValue().set("wc", demoBO);

        Object wc = redisTemplate.opsForValue().get("wc");
        System.out.println("wc: " + wc);
    }
}
