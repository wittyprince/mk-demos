package com.mk.demos.spring.cloud.openfeign.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * provider
 *
 * @author WangChen
 * Created on 2022/6/24
 * @since 1.0.0
 */
@RestController
@RequestMapping("/provider")

public class ProviderController {

    @PostMapping("/provide")
    @ResponseBody
    public ResponseEntity provide() {
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
