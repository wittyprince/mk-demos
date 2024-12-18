package com.mk.demos.reactor.nio;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * BlockingNIOClient
 *
 * @author WangChen
 * Created on 2024/12/18
 * @since 1.0
 */
public class BlockingNIOClient {

    public static void main(String[] args) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new java.net.InetSocketAddress("localhost", 7002));
            System.out.println("client start...");
//            new Thread(new NIOHandler(socketChannel)).start();
            // 分配缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // 向服务器发送数据
            buffer.put("沉默王二，这是来自客户端的消息。".getBytes(StandardCharsets.UTF_8));
            buffer.flip();
            socketChannel.write(buffer);
            // 清空缓冲区
            buffer.clear();

            // 关闭套接字
            socketChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
