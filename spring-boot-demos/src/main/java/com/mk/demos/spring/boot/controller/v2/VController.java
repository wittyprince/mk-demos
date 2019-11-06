package com.mk.demos.spring.boot.controller.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * v
 *
 * @author WangChen
 * Created on 2019/10/24 21:00
 * @since 1.0
 */
@RestController("v2")
//@RestController
@RequestMapping("/{version}")
public class VController {

    @GetMapping("/test")
    public String v(){
        return "v2";
    }
}
