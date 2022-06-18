package com.mk.demos.design.pattern.adapter;

/**
 * test类
 *
 * @author WangChen
 * Created on 2022/6/19
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {

        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);

        Client client = new Client(target);
        client.charge();

    }
}
