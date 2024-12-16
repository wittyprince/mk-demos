package com.mk.demos.reactor.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * BIOClient
 *
 * @author WangChen
 * Created on 2024/12/16
 * @since 1.0
 */
public class BIOClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 7001));
        System.out.println("client start...");
        socket.getOutputStream().write("hello server1\n".getBytes());
        socket.getOutputStream().write("hello server2\n".getBytes());
        socket.getOutputStream().flush();
        socket.getOutputStream().write("hello server3\n".getBytes());
        socket.getOutputStream().flush();

//        byte[] bytes = new byte[1024];
//        int len;
//        while ((len = socket.getInputStream().read(bytes)) != -1) {
//            System.out.println("receive from the server: " + new String(bytes, 0, len));
//        }


        socket.close();

    }
}
