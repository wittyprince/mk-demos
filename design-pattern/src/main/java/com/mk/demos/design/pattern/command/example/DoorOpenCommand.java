package com.mk.demos.design.pattern.command.example;

import com.mk.demos.design.pattern.command.Command;

/**
 * 命令模式-开门命令
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class DoorOpenCommand implements Command {
    private Door door;

    public DoorOpenCommand(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.open();
    }
}
