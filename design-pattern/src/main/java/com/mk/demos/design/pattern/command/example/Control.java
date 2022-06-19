package com.mk.demos.design.pattern.command.example;

import com.mk.demos.design.pattern.command.Command;

/**
 * 命令模式-控制器
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class Control {

    private Command slot;

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
