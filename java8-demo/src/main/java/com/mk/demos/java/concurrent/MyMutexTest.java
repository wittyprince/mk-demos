package com.mk.demos.java.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Mutex from AQS.Mutex
 *
 * @author WangChen
 * Created on 2024/10/26
 * @since 1.0
 */
public class MyMutexTest implements Lock, java.io.Serializable {

    // Our internal helper class
    private static class Sync extends MyAQS {
        // Acquires the lock if state is zero
        public boolean tryAcquire(int acquires) {
            assert acquires == 1; // Otherwise unused
            if (compareAndSetState(0, 1)) {
                // The current owner of exclusive mode synchronization.
                // 独占模式同步的当前所有者
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // Releases the lock by setting state to zero
        protected boolean tryRelease(int releases) {
            assert releases == 1; // Otherwise unused
            if (!isHeldExclusively())
                throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // Reports whether in locked state
        public boolean isLocked() {
            return getState() != 0;
        }

        public boolean isHeldExclusively() {
            // a data race, but safe due to out-of-thin-air guarantees
            // 数据竞争，但由于无缘无故的保证，所以是安全的
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        // Provides a Condition
        public Condition newCondition() {
            return new ConditionObject();
        }

        // Deserializes properly
        private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
            s.defaultReadObject();
            setState(0); // reset to unlocked state
        }
    }

    // The sync object does all the hard work. We just forward to it.
    // sync对象完成所有繁重的工作。我们只是转发给它。
    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    public void unlock() {
        sync.release(1);
    }

    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked() {
        return sync.isLocked();
    }

    public boolean isHeldByCurrentThread() {
        return sync.isHeldExclusively();
    }

    /**
     * Returns true if there may be other threads waiting to acquire the lock.
     * 如果可能有其他线程等待获取锁，则返回true。
     *
     * @return true if the given thread is the current owner
     */
    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

    public static void main(String[] args) throws InterruptedException {

        String a = "a";
        String b = "b";
        String c = "c";
        c = b = a; // 赋值顺序是从右向左 <-
        System.out.println(b);
        System.out.println(c);

        MyMutexTest mutex = new MyMutexTest();

        mutex.lockInterruptibly();
        mutex.lockInterruptibly();
        mutex.unlock();
        mutex.unlock();


    }
}
