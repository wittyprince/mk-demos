package com.mk.demos.finalizer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * try with resources
 *
 * 实现了 AutoCloseable 接口的类 在需要 关闭资源时, 可以使用try with resources代替try...finally...
 * 注意 AutoCloseable 是在jdk1.7中新增的接口
 * Closeable 是 jdk1.5中的接口，在jdk1.7中继承了 AutoCloseable
 *
 * @author WangChen
 * Created on 2019/12/15 14:01
 * @since 1.0
 */
public class TryWithResources {

    private static final int BUFFER_SIZE = 8 * 1024;

    // try-with-resources on multiple resources - short and sweet (Page 35)
    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}
