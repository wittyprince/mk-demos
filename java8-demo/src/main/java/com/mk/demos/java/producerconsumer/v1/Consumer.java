package com.mk.demos.java.producerconsumer.v1;

/**
 * 消费者
 *
 * @author WangChen
 * Created on 2022/8/11
 * @since 1.0
 */
public class Consumer implements Runnable{

    private Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    public void consume() {
        Goods goods = container.get();
        System.out.println("consuming... " + goods.getName());
    }

    @Override
    public void run() {
        while (true) {
            consume();
        }
    }
}
