package com.mk.demos.reactor.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author WangChen
 * Created on 2024/12/16
 * @since
 */
public class BIOHandler implements Runnable {

    private final Socket socket;
    public BIOHandler(Socket accept) {
        this.socket = accept;
    }

    public void run() {
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
//        finally {
//            try {
//                if (inputStream != null) {
//                    inputStream.close();
//                }
////                socket.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

    }
}
