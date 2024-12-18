package com.mk.demos.reactor.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * NIOHandler
 *
 * @author WangChen
 * Created on 2024/12/18
 * @since 1.0
 */
public class BlockingNIOHandler implements Runnable {

    private SocketChannel socketChannel;

    public BlockingNIOHandler() {
    }

    public BlockingNIOHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }


    @Override
    public void run() {
        System.out.println("handle the new client request...");
        // do something
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            // 读取数据
            int bytesRead = socketChannel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                System.out.println(StandardCharsets.UTF_8.decode(buffer));
                buffer.clear();
                bytesRead = socketChannel.read(buffer);
            }
            // 关闭套接字
            socketChannel.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
