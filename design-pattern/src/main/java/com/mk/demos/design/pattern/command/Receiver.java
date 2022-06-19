package com.mk.demos.design.pattern.command;

/**
 * 接受者
 *
 * 接收者 （Receiver） 类包含部分业务逻辑。
 * 几乎任何对象都可以作为接收者。
 * 绝大部分命令只处理如何将请求传递到接收者的细节， 接收者自己会完成实际的工作。
 *
 * [个人理解：指具体的厂商的产品，如Light, Door]
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class Receiver {

    public void on() { // 开
        // 处理业务逻辑
        // 接收者自己会完成实际的工作
        System.out.println("Receiver on ...");
    }

    public void off() { // 关
        System.out.println("Receiver off ...");
    }

}
