package com.mk.demos.reactor.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIOServer
 *
 * @author WangChen
 * Created on 2024/12/16
 * @since 1.0
 */
public class BIOServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(7001);
        System.out.println("server start...");
        Socket socket = serverSocket.accept();
//        Thread t1 = new Thread(new BIOHandler(socket));
//        t1.start();

        System.out.println("new client connected...");
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                System.out.println("receive from the client: " + new String(bytes, 0, len));
            }
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        OutputStream outputStream = socket.getOutputStream();
//        outputStream.write("Hello Client,I get a message.".getBytes("UTF-8"));
//        outputStream.flush();
//        outputStream.close();

        serverSocket.close();

    }
}
