package com.mk.demos.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.HashMap;
import com.alibaba.fastjson2.JSONObject;

/**
 * logging controller
 *
 * @author WangChen
 * Created on 2023/6/1
 * @since 1.0
 */
@RestController
@RequestMapping("/logging")
public class LoggingController {

    private final Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping("/logging")
    public String logging(@RequestParam("message") String message) {
        logger.trace("===trace==={}", message);
        logger.debug("===debug==={}", message);
        logger.info("===info==={}", message);
        logger.warn("===warn==={}", message);
        logger.error("===error==={}", message);
        logger.info(message);
        return "logging";
    }

    /**
     * 使用MaskingPatternLayout对控制台输出的信息进行过滤
     */
    @RequestMapping("/logging2")
    public String logging2() {
        Map<String, String> user = new HashMap<String, String>();
        user.put("user_id", "87656");
        user.put("SSN", "786445563");
        user.put("address", "22 Street");
        user.put("city", "Chicago");
        user.put("Country", "U.S.");
        user.put("ip_address", "192.168.1.1");
        user.put("email_id", "spring@baeldung.com");
        JSONObject userDetails = new JSONObject(user);

        logger.info("User JSON: {}", userDetails);
        return "logging2";
    }
}
