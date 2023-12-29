package com.mk.demos.spring.transaction.service.impl;

import com.mk.demos.spring.transaction.service.A1Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * a1 service impl
 *
 * @author WangChen
 * Created on 2022/8/17
 * @since 1.0
 */
@Service
public class A1ServiceImpl implements A1Service {

//    @Transactional
    @Override
    public void m1() {
        System.out.println("m1 before...");
        m2();

        System.out.println("m1 after...");
    }

//    @Transactional
    @Override
    public void m2() {
        System.out.println("m1 before...");
        double d = 1/0;

        System.out.println("m1 after...");
    }


}
