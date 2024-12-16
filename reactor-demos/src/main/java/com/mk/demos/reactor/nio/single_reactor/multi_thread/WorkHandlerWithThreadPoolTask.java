package com.mk.demos.reactor.nio.single_reactor.multi_thread;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * WorkHandlerWithThreadPoolTask
 *
 * @author WangChen
 * Created on 2024/12/16
 * @since 1.0
 */
public class WorkHandlerWithThreadPoolTask implements Runnable {

    private SocketChannel socketChannel;

    private ByteBuffer byteBuffer;

    public WorkHandlerWithThreadPoolTask(SocketChannel socketChannel, ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            System.out.println("task thread:" + Thread.currentThread().getName());
            String message = new String(byteBuffer.array(), StandardCharsets.UTF_8);
            System.out.println(socketChannel.getRemoteAddress() + "发来的消息是:" + message);
            String s = "你的消息我收到了" + message;
            socketChannel.write(ByteBuffer.wrap(s.getBytes(StandardCharsets.UTF_8)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
