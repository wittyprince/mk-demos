package com.mk.demos.reactor.nio;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * NonBlockingNIOClient
 *
 * @author WangChen
 * Created on 2024/12/18
 * @since 1.0
 */
public class NonBlockingNIOClient {

    public static void main(String[] args) {
        SocketChannel socketChannel;
        try {
            socketChannel = SocketChannel.open();
            // 设置为非阻塞模式
            socketChannel.configureBlocking(false);
            // 连接服务器
            socketChannel.connect(new java.net.InetSocketAddress("localhost", 7003));
            System.out.println("client start...");
//            new Thread(new NonBlockingNIOHandler(socketChannel)).start();
//            socketChannel.write(java.nio.ByteBuffer.wrap("沉默王二，这是来自客户端的消息。".getBytes(java.nio.charset.StandardCharsets.UTF_8)));

            while (!socketChannel.finishConnect()) {
                // 等待连接完成
                System.out.println("等待连接完成...");
            }
            // 分配缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // 向服务器发送数据
            String message = "你好，沉默王二，这是来自客户端的消息。";
            buffer.put(message.getBytes(StandardCharsets.UTF_8));
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
