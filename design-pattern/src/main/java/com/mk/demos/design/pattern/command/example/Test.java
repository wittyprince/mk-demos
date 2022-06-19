package com.mk.demos.design.pattern.command.example;

import com.mk.demos.design.pattern.command.example.Control;
import com.mk.demos.design.pattern.command.example.Light;
import com.mk.demos.design.pattern.command.example.LightOnCommand;

/**
 * 测试类
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {

        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        Control control = new Control();
        control.setCommand(lightOnCommand);
        control.buttonWasPressed();
    }
}
