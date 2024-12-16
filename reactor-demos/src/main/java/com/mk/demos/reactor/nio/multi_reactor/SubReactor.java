package com.mk.demos.reactor.nio.multi_reactor;

import com.mk.demos.reactor.nio.single_reactor.Acceptor;
import com.mk.demos.reactor.nio.single_reactor.multi_thread.WorkHandlerWithThreadPool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.LockSupport;

/**
 * SubReactor
 *
 * @author WangChen
 * Created on 2024/12/16
 * @since 1.0
 */
public class SubReactor implements Runnable {

    Selector selector;

    public SubReactor(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    // 对事件进行分发
                    dispatch(iterator.next());
                    iterator.remove();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            LockSupport.parkNanos(1000 * 1000 * 1000);
        }
    }

    private void dispatch(SelectionKey selectionKey) {
        Runnable runnable = (Runnable) selectionKey.attachment();
        runnable.run();
    }

    public Selector getSelector() {
        return selector;
    }
}
