package com.mk.demos.design.pattern.command;

/**
 * 测试类
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class Test {


    public static void main(String[] args) {
        Client client = new Client();

        Invoker invoker = new Invoker(client.getCommand());
        invoker.invoke();
    }
}
