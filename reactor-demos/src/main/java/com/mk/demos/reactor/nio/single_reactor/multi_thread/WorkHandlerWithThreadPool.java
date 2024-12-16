package com.mk.demos.reactor.nio.single_reactor.multi_thread;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * WorkHandlerWithThreadPool
 *
 * @author WangChen
 * Created on 2024/12/16
 * @since 1.0
 */
public class WorkHandlerWithThreadPool implements Runnable {

    private ExecutorService pool = Executors.newFixedThreadPool(2);

    private SocketChannel socketChannel;

    public WorkHandlerWithThreadPool(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            System.out.println("WorkHandlerWithThreadPool thread:" + Thread.currentThread().getName());
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            socketChannel.read(byteBuffer);
//            String message = new String(byteBuffer.array(), StandardCharsets.UTF_8);
//            System.out.println(socketChannel.getRemoteAddress() + "发来的消息是:" + message);
//            socketChannel.write(ByteBuffer.wrap("你的消息我收到了".getBytes(StandardCharsets.UTF_8)));
            pool.execute(new WorkHandlerWithThreadPoolTask(socketChannel, byteBuffer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
