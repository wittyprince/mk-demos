package com.mk.demos.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * a
 *
 * @author WangChen
 * Created on 2024/12/3
 * @since 1.0
 */
@Service
public class A {

    // 这里使用setter方法注入，与B使用构造器注入，不会导致循环引用
    @Autowired
    private B b;

//    A (B b) {
//        this.b = b;
//    }
}
