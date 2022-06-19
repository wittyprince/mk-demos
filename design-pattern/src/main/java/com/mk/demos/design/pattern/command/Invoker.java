package com.mk.demos.design.pattern.command;

/**
 * 调用者
 *
 * 发送者 （Sender）——亦称 “触发者 （Invoker）”
 *      ——类负责对请求进行初始化，
 * 其中必须包含一个成员变量来存储对于命令对象的引用。
 * 发送者触发命令， 而不向接收者直接发送请求。
 * 注意， 发送者并不负责创建命令对象： 它通常会通过构造函数从客户端处获得预先生成的命令。
 *
 * [个人理解：指集成器(中间商)，如遥控器Control]
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    /**
     * 调用命令的方法入口
     */
    public void invoke() {
        command.execute();
    }
}
