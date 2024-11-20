package com.mk.demos.java.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * NonReentrantLock
 *
 * @author WangChen
 * Created on 2024/11/20
 * @since 1.0
 */
public class NonReentrantLock implements Lock {

    private final Sync sync = new Sync();

    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            if (arg != 1) {
                throw new IllegalArgumentException();
            }
            if (compareAndSetState(0, 1)) {
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (arg != 1) {
                throw new IllegalArgumentException();
            }
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        public Condition newCondition() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {

        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public static void main(String[] args) {
        NonReentrantLock lock = new NonReentrantLock();
        lock.lock();
        lock.unlock();
        lock.lock();
        lock.unlock();
    }
}
