package com.mk.demos.design.pattern.command;

/**
 * 具体的命令
 *
 * 具体命令 （Concrete Commands） 会实现各种类型的请求。 具体命令自身并不完成工作， 而是会将调用委派给一个业务逻辑对象。 但为了简化代码， 这些类可以进行合并。
 *
 * 接收对象执行方法所需的参数可以声明为具体命令的成员变量。 你可以将命令对象设为不可变， 仅允许通过构造函数对这些成员变量进行初始化。
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class OnCommand implements Command{

    private Receiver receiver;

    public OnCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.on();
    }
}
