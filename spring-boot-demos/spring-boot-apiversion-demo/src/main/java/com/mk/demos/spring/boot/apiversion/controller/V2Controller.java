package com.mk.demos.spring.boot.apiversion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.demos.spring.boot.apiversion.annotation.ApiVersion;

/**
 * V2Controller
 *
 * @author WangChen
 * Created on 2019/10/24 17:26
 * @since 1.0
 */
@RequestMapping("/{version}/version")
@RestController
@ApiVersion(2)
public class V2Controller {

    @GetMapping
    public String test() {
        System.out.println("version2");
        return "version2";
    }
}
