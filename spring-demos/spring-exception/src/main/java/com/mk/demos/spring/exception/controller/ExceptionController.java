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
// @RestController is a convenience annotation that is itself annotated with @Controller and @ResponseBody.
// This annotation is applied to a class to mark it as a request handler.
    // @Controller is a common annotation that is used to mark a class as Spring MVC Controller.
    // @ResponseBody is a Spring annotation that binds a method return value to the web response body.
// 由于项目使用的是spring-context.xml配置文件，所以这里不需要使用@RestController注解
//@RestController
@RequestMapping("/exception")
public class ExceptionController {

//    @Autowired
//    private ExceptionService exceptionService;

    @RequestMapping("/test")
    public String test() {
        throw new CustomException("test exception");
    }

    @ExceptionHandler({CustomException.class, Exception.class})
    public void handleException() {
        System.err.println("handle exception...");
    }
}
