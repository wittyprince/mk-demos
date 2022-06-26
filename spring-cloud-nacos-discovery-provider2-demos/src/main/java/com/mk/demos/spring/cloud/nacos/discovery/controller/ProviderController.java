package com.mk.demos.spring.cloud.nacos.discovery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * provider controller
 *
 * @author WangChen
 * Created on 2022/6/26
 * @since 1.0.0
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @GetMapping("/provide/{str}")
    public String provide(@PathVariable String str) {
        return "provide2..." + str;
    }
}
