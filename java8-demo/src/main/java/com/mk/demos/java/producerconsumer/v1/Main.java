package com.mk.demos.java.producerconsumer.v1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试类
 *
 * @author WangChen
 * Created on 2022/8/11
 * @since 1.0
 */
public class Main {

    public static void main(String[] args) {

        Container container = new Container();

        Producer producer = new Producer(container);

        ExecutorService producerPool = Executors.newSingleThreadExecutor();
        producerPool.execute(producer);
//        Future<?> submit = producerPool.submit(producer);

        Consumer consumer = new Consumer(container);
        ExecutorService consumerPool = Executors.newFixedThreadPool(2);
        consumerPool.execute(consumer);

//        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
//        scheduledThreadPool.schedule(consumer, 3, TimeUnit.SECONDS);

        System.out.println("Main end...");
    }
}
