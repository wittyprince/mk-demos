package com.mk.demos.reactor.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * NonBlockingNIOServer
 *
 * @author WangChen
 * Created on 2024/12/18
 * @since 1.0
 */
public class NonBlockingNIOServer {

    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new java.net.InetSocketAddress(7003));
            // 设置为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            System.out.println("server start...");

//            new Thread(new NIOReactor(serverSocketChannel)).start();

            // 创建选择器
            Selector selector = Selector.open();
            // 注册服务器套接字到选择器
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                // 选择一组键，其相应的通道已为 I/O 操作准备就绪
                selector.select();
                // 返回此选择器的已选择键集
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    // 处理新接入的请求消息
                    if (selectionKey.isAcceptable()) {
//                        new NIOHandler(serverSocketChannel.accept(), selector);
                        // 接收客户端连接
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }
                    if (selectionKey.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
//                        new NIOHandler(socketChannel);
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int bytesRead = socketChannel.read(buffer);

                        if (bytesRead != -1) {
                            buffer.flip();
                            System.out.println(StandardCharsets.UTF_8.decode(buffer));
                            buffer.clear();
                        } else {
                            // 客户端已断开连接，取消选择键并关闭通道
                            selectionKey.cancel();
                            socketChannel.close();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
