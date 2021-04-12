package com.mk.demos.spring.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * index controller
 *
 * @author WangChen
 * Created on 2021/4/11 15:31
 * @since 1.0
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/idx")
    public String index() {
        System.out.println("idx...");
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    public ResponseEntity hello() {

        System.out.println("hello...");
        return new ResponseEntity("{a:A}", HttpStatus.OK);
    }
}
