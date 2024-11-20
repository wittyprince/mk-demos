package com.mk.demos.java.concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;

/**
 * ProducerConsumerModel
 *
 * @author WangChen
 * Created on 2024/11/20
 * @since 1.0
 */
public class ProducerConsumerModel {

    private static final NonReentrantLock lock = new NonReentrantLock();
    private static final Condition notFull = lock.newCondition();
    private static final Condition notEmpty = lock.newCondition();

    private static final Queue<String> queue = new LinkedList<>();
    private static final int queueLength = 10;        // 队列长度

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            int i = 0;
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == queueLength) {
                        System.out.println("Queue is full!");
                        notFull.await();
                    }
                    Thread.sleep(2000);
                    System.out.println("Produce product: " + "product" + i);
                    queue.add("product" + i);
                    ++i;
                    notEmpty.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (queue.isEmpty()) {
                        System.out.println("Queue is empty!");
                        notEmpty.await();
                    }
                    Thread.sleep(2000);
                    String product = queue.poll();
                    System.out.println("Consume product: " + product);
                    notFull.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
