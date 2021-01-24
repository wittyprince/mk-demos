package com.mk.demos.design.pattern.strategy;

/**
 * 策略抽象类
 *
 * @author WangChen
 * Created on 2021/1/24 10:09
 * @since 1.0
 */
public interface Strategy {

    String s = "";// 接口中也可以定义变量，不过需要初始化
    void doOperation();
}
