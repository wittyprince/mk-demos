package com.mk.demos.java8.lambda.FunctionalProgramming;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * 有副作用的示例
 *
 * @author WangChen
 * Created on 2021/7/11 16:12
 * @since 0.1
 */
public class SideEffect {

    Button button = new Button();

    ActionEvent globalEvent = null; // 全局变量

    private void registerHandler() {
        ActionEvent localEvent = null; // 局部变量
        button.addActionListener(e -> { // 有副作用，即给变量赋值是一种副作用
            globalEvent = e; // 全局变量能编译通过
            // Variable used in lambda expression should be final or effectively final
//            localEvent = e; // 局部变量编译不通过，为何 ???
        });
    }
}
