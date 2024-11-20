package com.mk.demos.java.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * BooleanLatchTest
 *
 * @author WangChen
 * Created on 2024/10/29
 * @since 1.0
 */
public class BooleanLatchTest {

    private static class Sync extends AbstractQueuedSynchronizer {
        boolean isSignalled() {
            return getState() != 0;
        }

        protected int tryAcquireShared(int ignore) {
            return isSignalled() ? 1 : -1;
        }

        protected boolean tryReleaseShared(int ignore) {
            // 这里为什么是setState(1)而不是setState(0)呢？
            setState(1);
            return true;
        }
    }

    private final Sync sync = new Sync();

    public boolean isSignalled() {
        return sync.isSignalled();
    }

    public void signal() {
        sync.releaseShared(1);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
//        sync.acquireShared(1);
    }

    public static void main(String[] args) {
        BooleanLatchTest booleanLatch = new BooleanLatchTest();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("signal");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            booleanLatch.signal();
        }).start();

        try {
            System.out.println("await");
            booleanLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
