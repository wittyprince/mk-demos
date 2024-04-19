package com.mk.demos.spring.exception.controller;

import com.mk.demos.spring.exception.exception.CustomException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ExceptionController
 *
 * @author WangChen
 * Created on 2024/4/18
 * @since 1.0
 */
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping("/test")
    public String test() {
        throw new CustomException("test exception");
    }

    @ExceptionHandler({CustomException.class})
    public void handleException() {
        System.err.println("handle exception...");
    }
}
