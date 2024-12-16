package com.mk.demos.reactor.nio.single_reactor;

import com.mk.demos.reactor.nio.single_reactor.multi_thread.WorkHandlerWithThreadPool;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Acceptor
 *
 * @author WangChen
 * Created on 2024/12/16
 * @since 1.0
 */
public class Acceptor implements Runnable {
    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    public Acceptor(Selector selector, ServerSocketChannel serverSocketChannel) {
        this.selector = selector;
        this.serverSocketChannel = serverSocketChannel;
    }

    @Override
    public void run() {
        try {
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("有客户端连接上来了," + socketChannel.getRemoteAddress());
            socketChannel.configureBlocking(false);
            SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
            //TODO 这里关注的是WorkHandler时，就是单Reactor单线程
            //TODO 这里关注的是WorkHandlerWithThreadPool时，就是单Reactor多线程
//            selectionKey.attach(new WorkHandler(socketChannel));
            selectionKey.attach(new WorkHandlerWithThreadPool(socketChannel));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
