package com.mk.demos.undertow.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MyController
 *
 * @author WangChen
 * Created on 2023/6/6
 * @since 1.0
 */
@RestController
public class MyController {

    @GetMapping(value="/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String home() {

        return "Home page";
    }
}
