package com.mk.demos.java.producerconsumer.v1;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 存放物品的地方，即容器
 *
 * @author WangChen
 * Created on 2022/8/11
 * @since 1.0
 */
public class Container {

    final private LinkedList<Goods> lists = new LinkedList<>();
    final private int MAX = 10; // 容器最大量
    private int count = 0; // 当前容量

    public void put2(Goods goods) {
        synchronized (lists) {
            while (count == MAX) {
                try {
                    lists.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lists.add(goods);
            count++;
            lists.notifyAll();
        }
    }

    public Goods get2() {
        Goods goods;
        synchronized (lists) {
            while (count == 0) {
                try {
                    lists.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            goods = lists.remove();
            count--;
            lists.notifyAll();
        }
        return goods;
    }

    public void put(Goods e) {
//        putByWaitAndNotify(e);
        putByLock(e);
    }

    public Goods get()  {
        Goods e;
//        e = getByWaitAndNotify();
        e = getByLock();
        return e;
    }

    // 方式一：wait/notifyAll
    private void putByWaitAndNotify(Goods e) {
        synchronized (lists){
            while (lists.size() == MAX){
                try {
                    lists.wait();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            lists.add(e);
            count++;
            System.out.println("put " + count + "_" + e.getName());
            lists.notifyAll();
        }
    }

    private Goods getByWaitAndNotify() {
        Goods e;
        synchronized (lists){
            while (lists.size() == 0){
                try {
                    lists.wait();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            e = lists.remove();
            System.out.println("get " + count + "_" + e.getName());
            count--;
            lists.notifyAll();
        }
        return e;
    }

    // 方法二：ReentrantLock.Condition
    Lock lock = new ReentrantLock();
    private Condition consumer = lock.newCondition();
    private Condition producer = lock.newCondition();

    public void putByLock(Goods goods) {
        try {
            lock.lock();
            while (count == MAX) {
                producer.await();
            }
            lists.add(goods);
            count++;
            consumer.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Goods getByLock() {
        Goods goods = null;
        try {
            lock.lock();
            while (count == 0) {
                    consumer.await();
            }
            goods = lists.remove();
            count--;
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return goods;
    }


}
