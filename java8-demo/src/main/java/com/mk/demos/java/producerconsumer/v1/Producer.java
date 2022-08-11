package com.mk.demos.java.producerconsumer.v1;

import java.util.Random;

/**
 * 生产者
 *
 * @author WangChen
 * Created on 2022/8/11
 * @since 1.0
 */
public class Producer implements Runnable{

    private Container container;

    public Producer(Container container) {
        this.container = container;
    }

    public void produce() {
        Goods goods = new Goods(new Random().nextInt() + "");
        System.out.println("putting..." + goods.getName());
        container.put(goods);
    }

    @Override
    public void run() {
        while (true) {
            produce();
        }
    }
}
