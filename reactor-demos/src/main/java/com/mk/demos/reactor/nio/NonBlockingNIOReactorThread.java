package com.mk.demos.reactor.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author WangChen
 * Created on 2024/12/18
 * @since
 */
public class NonBlockingNIOReactorThread implements Runnable {

    private final SocketChannel socketChannel;

    public NonBlockingNIOReactorThread(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        System.out.println("handle the new client request...");
        // do something
        // 读取数据
        // 关闭套接字
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = 0;
        try {
            bytesRead = socketChannel.read(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (bytesRead != -1) {
            buffer.flip();
            System.out.print(StandardCharsets.UTF_8.decode(buffer));
            buffer.clear();
        } else {
            //TODO 客户端已断开连接，取消选择键并关闭通道
//            selectionKey.cancel();
//            socketChannel.close();
        }
    }
}
