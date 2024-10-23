package com.mk.demos.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * CLHLock
 *
 * @author WangChen
 * Created on 2024/10/22
 * @since 1.0
 */
public class CLHLock implements MyLock1 {

    // 尾指针，始终指向队列的最后一个节点。
    private final AtomicReference<QNode> tail;
    // 当前节点，表示自己，每个线程独有一个。
    private final ThreadLocal<QNode> current;
    // 前驱节点，每个线程独有一个。
    private final ThreadLocal<QNode> previous;

    public CLHLock() {
        // 初始状态 tail指向一个新node(head)节点
        tail = new AtomicReference<>(new QNode());
        current = ThreadLocal.withInitial(QNode::new);
//        previous = ThreadLocal.withInitial(() -> null);
        previous = new ThreadLocal<>();
    }

    @Override
    public void lock() {
        // 获取当前线程的代表节点
        QNode cur = current.get();
        // 将自己的状态设置为true表示 等待获取锁 或 已经获取锁。
        cur.locked = true;
        // 将自己放在队列的尾巴，并且返回以前的值。第一次进将获取构造函数中的那个new QNode
        QNode prev = tail.getAndSet(cur);
        // 把旧的节点放入前驱节点。
        previous.set(prev);
        // 在等待前驱节点的locked域变为false，这是一个自旋等待的过程
        while (prev.locked) {
//            System.out.println("lock thread: " + Thread.currentThread().getName() + " is waiting.");
        }
    }

//    @Override
//    public void lockInterruptibly() throws InterruptedException {
//
//    }
//
//    @Override
//    public boolean tryLock() {
//        return false;
//    }
//
//    @Override
//    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
//        return false;
//    }

    @Override
    public void unlock() {
        // unlock. 获取自己的node。把自己的locked设置为false。
        QNode cur = current.get();
        cur.locked = false;
        // 将当前node指向前驱node，这样操作等于把当前node从链表头部删除（并不是被JVM回收），
        // 其实这里指向的是初始化 new CLHLock() 时的那个new QNode()
        current.set(previous.get());
    }

//    @Override
//    public Condition newCondition() {
//        return null;
//    }

    private static class QNode {
        volatile boolean locked = false;
    }


    public static void main(String[] args) throws InterruptedException {
        CLHLock lock = new CLHLock();
        System.out.println("lock");
        System.out.println("current thread: " + Thread.currentThread().getName() + " is running.");
        System.out.println("main tail " + lock.tail.get());
        System.out.println("main current " + lock.current.get());
        System.out.println("main previous " + lock.previous.get());
        lock.lock();
        System.out.println("main2 previous " + lock.previous.get());
        System.out.println("main2 current " + lock.current.get());
        System.out.println("main2 tail " + lock.tail.get());
        Thread.sleep(1_000);
        lock.unlock();
        System.out.println("unlock");

        Thread t1 = new Thread(() -> {
            lock.lock();
            //TODO 由于线程池的线程是复用的，所以这里的输出可能会有问题，参考TTL
            // 这里暂时把核心线程数设置大于任务数，这样就不会有线程复用的问题
            System.out.println("t1 lock");
            System.out.println("t1 current thread: " + Thread.currentThread().getName() + " is running.");
            System.out.println("t1 previous " + lock.previous.get());
            // 这里为什么会是新的QNode?
            // 新的QNode是在何时创建的？
            //  1. 在构造函数中创建的
            //     不对
            //  2. 在lock方法中创建的
            //     java.lang.ThreadLocal.SuppliedThreadLocal.initialValue()方法中返回的supplier.get();
            //  3. 在unlock方法中创建的
            //     不对
            System.out.println("t1 current " + lock.current.get());
            System.out.println("t1 tail " + lock.tail.get());
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            System.out.println("t1 unlock");
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("t2 lock");
                System.out.println("t2 current thread: " + Thread.currentThread().getName() + " is running.");
                System.out.println("t2 previous " + lock.previous.get());
                System.out.println("t2 current " + lock.current.get());
                System.out.println("t2 tail " + lock.tail.get());
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                System.out.println("t2 unlock");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("t3 lock");
                System.out.println("t3 current thread: " + Thread.currentThread().getName() + " is running.");
                System.out.println("t3 previous " + lock.previous.get());
                System.out.println("t3 current " + lock.current.get());
                System.out.println("t3 tail " + lock.tail.get());
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                System.out.println("t3 unlock");
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("t4 lock");
                System.out.println("t4 current thread: " + Thread.currentThread().getName() + " is running.");
                System.out.println("t4 previous " + lock.previous.get());
                System.out.println("t4 current " + lock.current.get());
                System.out.println("t4 tail " + lock.tail.get());
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                System.out.println("t4 unlock");
            }
        });

        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("t5 lock");
                System.out.println("t5 current thread: " + Thread.currentThread().getName() + " is running.");
                System.out.println("t5 previous " + lock.previous.get());
                System.out.println("t5 current " + lock.current.get());
                System.out.println("t5 tail " + lock.tail.get());
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                System.out.println("t5 unlock");
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        executorService.execute(t1);
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.execute(t2);
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.execute(t3);
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.execute(t4);
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.execute(t5);

    }
}
