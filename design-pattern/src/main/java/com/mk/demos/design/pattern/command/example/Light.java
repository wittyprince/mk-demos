package com.mk.demos.design.pattern.command.example;

/**
 * 命令模式-Light
 *
 * 具体厂商提供的产品
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class Light {

    public void on() {
        System.out.println("light on ...");
    }

    public void off() {
        System.out.println("light off ...");
    }
}
