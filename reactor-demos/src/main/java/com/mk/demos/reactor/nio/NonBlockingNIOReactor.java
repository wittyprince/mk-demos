package com.mk.demos.reactor.nio;

import java.nio.channels.ServerSocketChannel;

/**
 * @author WangChen
 * Created on 2024/12/18
 * @since
 */
public class NonBlockingNIOReactor implements Runnable {

    private final ServerSocketChannel serverSocketChannel;
    public NonBlockingNIOReactor(ServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
//        // 创建选择器
//        Selector selector = Selector.open();
//        // 注册服务器套接字到选择器
//        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    @Override
    public void run() {
        try {
            new NonBlockingNIOReactorThread(serverSocketChannel.accept()).run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
