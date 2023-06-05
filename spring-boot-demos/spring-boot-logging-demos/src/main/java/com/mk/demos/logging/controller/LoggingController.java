package com.mk.demos.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
