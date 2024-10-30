package com.mk.demos.java.concurrent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * FIFOMutexTest
 * a first-in-first-out non-reentrant lock class
 *
 * @author WangChen
 * Created on 2024/10/30
 * @since 1.0
 */
public class FIFOMutexTest {

    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters = new ConcurrentLinkedQueue<>();

    public void lock() {
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        waiters.add(current);
        // Block while not first in queue or cannot acquire lock
        while (waiters.peek() != current || !locked.compareAndSet(false, true)) {
            LockSupport.park(this);
            if (Thread.interrupted())
                // ignore interrupts while waiting
                wasInterrupted = true;
        }
        waiters.remove();
        if (wasInterrupted)
            // reassert interrupt status on exit
            current.interrupt();
    }

    public void unlock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }

    public static void main(String[] args) {
        // =============代码块1============================================================================
        FIFOMutexTest fifoMutex = new FIFOMutexTest();
        Thread t1 = new Thread(() -> {
            fifoMutex.lock();
            System.out.println("Thread1 get lock");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fifoMutex.unlock();
            System.out.println("Thread1 release lock");
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            fifoMutex.lock();
            System.out.println("Thread2 get lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fifoMutex.unlock();
            System.out.println("Thread2 release lock");
        });
        // 这里必须等到t1释放锁之后，t2才能获取锁
        t2.start();
        // =========================================================================================



        // ===========代码块2==============================================================================
        Thread thread = new Thread(() -> {
            System.out.println("Thread start: " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
            LockSupport.unpark(Thread.currentThread());
            System.out.println("Thread unpark: " + Thread.currentThread().getName());
            LockSupport.park(); // 阻塞自己
            System.out.println("Thread end: " + Thread.currentThread().getName());
        });

        thread.setName("A");
        thread.start();

        System.out.println("Main thread started: " + Thread.currentThread().getId());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread sleep 3 second: " + Thread.currentThread().getId());
        LockSupport.unpark(thread); // 唤醒线程 A
        // 线程 A 在启动之后调用了 LockSupport#park 方法将自己阻塞，
        // 主线程在休息 3 秒之后调用 LockSupport#unpark 方法线程 A 唤醒。运行结果：
        // Main thread started: 1
        // Thread start: A
        // Main thread sleep 3 second: 1
        // Thread end: A
        // =========================================================================================
    }
}
