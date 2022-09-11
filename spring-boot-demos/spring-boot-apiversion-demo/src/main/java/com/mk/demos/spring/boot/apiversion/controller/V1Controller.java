package com.mk.demos.spring.boot.apiversion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * V1Controller
 *
 * @author WangChen
 * Created on 2019/10/24 17:25
 * @since 1.0
 */
@RequestMapping("/{version}/version")
@RestController
public class V1Controller {

    @GetMapping
    public String test() {
        System.out.println("version1");
        return "version1";
    }
    @GetMapping("/extend")
    public String extendTest() {
        System.out.println("version1/extend");
        return "extend";
    }
}
