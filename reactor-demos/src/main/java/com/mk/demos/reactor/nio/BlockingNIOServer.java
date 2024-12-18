package com.mk.demos.reactor.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * BlockingNIOServer
 *
 * @author WangChen
 * Created on 2024/12/18
 * @since 1.0
 */
public class BlockingNIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new java.net.InetSocketAddress(7002));
        // 设置为阻塞模式（默认为阻塞模式）
        serverSocketChannel.configureBlocking(true);
        System.out.println("server start...");
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("new client connected...");
            new Thread(new BlockingNIOHandler(socketChannel)).start();
        }
    }
}
