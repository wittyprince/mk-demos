package com.mk.demos.java11.concurrent;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

/**
 * AqsNode
 *
 * @author WangChen
 * Created on 2024/10/23
 * @since 1.0
 */
public class AqsNode {

    static final AqsNode SHARED = new AqsNode();
    static final AqsNode EXCLUSIVE = null;

    static final int CANCELLED = 1;
    static final int SIGNAL = -1;
    static final int CONDITION = -2;
    static final int PROPAGATE = -3;

    volatile int waitStatus;

    volatile AqsNode prev;

    volatile AqsNode next;

    volatile Thread thread;

    AqsNode nextWaiter;

    final boolean isShared() {
        return nextWaiter == SHARED;
    }

    final AqsNode predecessor() {
        AqsNode p = prev;
        if (p == null)
            throw new NullPointerException();
        else
            return p;
    }

    AqsNode() {
    }

    AqsNode(AqsNode nextWaiter) {
        this.nextWaiter = nextWaiter;
        THREAD.set(this, Thread.currentThread());
    }

    AqsNode(int waitStatus) {
        WAITSTATUS.set(this, waitStatus);
        THREAD.set(this, Thread.currentThread());
    }

    final boolean compareAndSetWaitStatus(int expect, int update) {
        return WAITSTATUS.compareAndSet(this, expect, update);
    }

    final boolean compareAndSetNext(AqsNode expect, AqsNode update) {
        return NEXT.compareAndSet(this, expect, update);
    }

    final void setPrevRelaxed(AqsNode p) {
        PREV.set(this, p);
    }

    private static final VarHandle NEXT;
    private static final VarHandle PREV;
    private static final VarHandle THREAD;
    private static final VarHandle WAITSTATUS;

    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            NEXT = l.findVarHandle(AqsNode.class, "next", AqsNode.class);
            PREV = l.findVarHandle(AqsNode.class, "prev", AqsNode.class);
            THREAD = l.findVarHandle(AqsNode.class, "thread", Thread.class);
            WAITSTATUS = l.findVarHandle(AqsNode.class, "waitStatus", int.class);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void main(String[] args) throws Exception {
        AqsNode head = new AqsNode();
        AqsNode next = new AqsNode(AqsNode.EXCLUSIVE);
        head.next = next;
        next.prev = head;
        AqsNode tail = new AqsNode(AqsNode.EXCLUSIVE);
        next.next = tail;
        tail.prev = next;
        List<Thread> threads = new ArrayList<>();
        for (AqsNode node = head; node != null; node = node.next) {
            threads.add(node.thread);
        }
        System.out.println(threads);
    }
}
