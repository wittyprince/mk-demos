package com.mk.demos.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用以解决Spring3.1中的WebApplicationInitializer接口无法提供web.xml中的welcome-file-list 问题
 *
 * @author WangChen
 * Created on 2021/4/11 17:44
 * @since 1.0
 */
@Controller
public class WelcomeController {
    @RequestMapping(value = { "/" })
    public String homePage() {
        return "../welcome";
    }
}
