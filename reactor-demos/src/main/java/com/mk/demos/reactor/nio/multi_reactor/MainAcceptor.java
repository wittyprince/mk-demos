package com.mk.demos.reactor.nio.multi_reactor;

import com.mk.demos.reactor.nio.single_reactor.multi_thread.WorkHandlerWithThreadPool;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * MultiAcceptor
 *
 * @author WangChen
 * Created on 2024/12/16
 * @since 1.0
 */
public class MainAcceptor implements Runnable {

//    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    // 指定从Reactor一共有16个
    private static final int TOTAL_SUBREACTOR_NUM = 16;

    // 用于运行从Reactor
    private final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            TOTAL_SUBREACTOR_NUM, TOTAL_SUBREACTOR_NUM * 2,
            60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(200));

    // 从Reactor集合
    private final List<SubReactor> subReactors = new ArrayList<>(TOTAL_SUBREACTOR_NUM);

    public MainAcceptor(ServerSocketChannel serverSocketChannel) throws IOException {
        this.serverSocketChannel = serverSocketChannel;
        // 将从Reactor初始化出来并运行
        for (int i = 0; i < TOTAL_SUBREACTOR_NUM; i++) {
            SubReactor subReactor = new SubReactor(Selector.open());
            subReactors.add(subReactor);
            threadPool.execute(subReactor);
        }
    }

    @Override
    public void run() {
        try {
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("有客户端连接上来了," + socketChannel.getRemoteAddress());
            socketChannel.configureBlocking(false);
//            Selector selector = subReactors.get(0).getSelector();
//            // 任意选择一个从Reactor，让其监听连接的客户端的READ事件
            Selector selector = subReactors.stream().findAny().orElseGet(null).getSelector();
            //TODO 从Reactor的多路复用器会阻塞在select()方法上
            // 这里需要先唤醒多路复用器，立即从select()方法返回
            selector.wakeup();
            SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
            selectionKey.attach(new WorkHandlerWithThreadPool(socketChannel));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
