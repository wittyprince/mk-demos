package com.mk.demos.design.pattern.command.example;

import com.mk.demos.design.pattern.command.Command;

/**
 * 命令模式-具体命令
 *
 * 由厂商提供，对应其提供的产品的操作命令
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
