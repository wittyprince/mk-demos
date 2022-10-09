package com.mk.demos.spring.boot.test.controller;

import com.mk.demos.spring.boot.test.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * demo controller
 *
 * @author WangChen
 * Created on 2022/10/9
 * @since 1.0
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @ResponseBody
    @GetMapping("/hello")
    public String hello(String name) {
        return demoService.hello(name);
    }
}
