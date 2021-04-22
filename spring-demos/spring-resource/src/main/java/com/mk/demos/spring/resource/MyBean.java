package com.mk.demos.spring.resource;


import org.springframework.core.io.Resource;

/**
 * @author WangChen
 * Created on 2021/4/22 10:06
 * @since 1.0
 */
public class MyBean {

    // 注意这里是 Spring 的 Resource
    // 不是javax.annotation中的Resource
    private Resource template;

    public Resource getTemplate() {
        return template;
    }

    public void setTemplate(Resource template) {
        this.template = template;
    }
}
