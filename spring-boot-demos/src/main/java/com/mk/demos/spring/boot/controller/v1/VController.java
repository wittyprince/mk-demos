package com.mk.demos.spring.boot.controller.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * v
 *
 * @author WangChen
 * Created on 2019/10/24 20:47
 * @since 1.0
 */
//@Controller("v1")
@Controller
@RequestMapping("/{version}")
public class VController {

    @GetMapping("/test")
    @ResponseBody
    public String v(){
        return "v1";
    }
}
