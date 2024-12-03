package com.mk.demos.tx.service;

import org.springframework.stereotype.Service;

/**
 * b
 *
 * @author WangChen
 * Created on 2024/12/3
 * @since 1.0
 */
@Service
public class B {

//    @Autowired
    private A a;

    B (A a) {
        this.a = a;
    }
}
