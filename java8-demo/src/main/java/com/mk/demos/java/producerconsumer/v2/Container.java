package com.mk.demos.java.producerconsumer.v2;

import com.mk.demos.java.producerconsumer.v1.Goods;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * container
 *
 * @author WangChen
 * Created on 2024/11/20
 * @since 1.0
 */
public class Container {

    private final LinkedList<Goods> lists = new LinkedList<>();

    private final int MAX = 10;

    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition producerCondition = lock.newCondition();
    private Condition consumerCondition = lock.newCondition();


    public void put(Goods goods) {
//        putByWaitAndNotify(goods);
        putByLock(goods);
    }

    public Goods get() {
//        return getByWaitAndNotify();
        return getByLock();
    }

    private void putByWaitAndNotify(Goods goods) {
        synchronized (lists) {
            while (count == MAX) {
                try {
                    lists.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            lists.add(goods);
            count++;
            lists.notifyAll();
        }
    }

    private Goods getByWaitAndNotify() {
        synchronized (lists) {
            while (count == 0) {
                try {
                    lists.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Goods remove = lists.remove();
            count--;
            lists.notifyAll();
            return remove;
        }
    }

    private void putByLock(Goods goods) {
        lock.lock();
        try {
            while (count == MAX) {
                producerCondition.await();
            }
            lists.add(goods);
            count++;
            consumerCondition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    private Goods getByLock() {
        Goods remove;
        lock.lock();
        try {
            while (count == 0) {
                consumerCondition.await();
            }
            remove = lists.remove();
            count--;
            producerCondition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        return remove;
    }


    public static void main(String[] args) {
        Container container = new Container();
        Thread producerThread = new Thread(() -> {
            int i = 0;
            while (true) {
                container.put(new Goods("product" + i));
                System.out.println("producing... " + "product" + i);
                i++;
            }
        }, "producer");

        Thread consumerThread = new Thread(() -> {
            while (true) {
                Goods goods = container.get();
                System.out.println("consuming... " + goods.getName());
            }
        }, "consumer");
//        producerThread.start();
//        consumer.start();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(producerThread);
        executorService.execute(producerThread);
        executorService.execute(consumerThread);

//        Condition producerCondition = container.lock.newCondition();
//        Condition consumerCondition = container.lock.newCondition();

    }
}
