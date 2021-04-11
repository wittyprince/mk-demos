package com.mk.demos.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index controller
 *
 * @author WangChen
 * Created on 2021/4/11 13:28
 * @since 1.0
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/idx")
    public String index() {
        return "index";
    }

}
