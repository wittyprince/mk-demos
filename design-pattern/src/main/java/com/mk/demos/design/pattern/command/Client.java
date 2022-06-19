package com.mk.demos.design.pattern.command;

/**
 * 客户端
 *
 * 客户端 （Client） 会创建并配置具体命令对象。
 * 客户端必须将包括接收者实体在内的所有请求参数传递给命令的构造函数。
 * 此后， 生成的命令就可以与一个或多个发送者相关联了。
 *
 * [个人理解：指具体的厂商，如Light厂商, Door厂商]
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class Client {

    private Receiver receiver;

    private OnCommand onCommand;

    public Client() {
        this.receiver = new Receiver();
        this.onCommand = new OnCommand(receiver);
    }

    public OnCommand getCommand() {
        return onCommand;
    }
}
