package com.mk.demos.java.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化测试
 *
 * @author WangChen
 * Created on 2022/9/6
 * @since 1.0
 */
public class SerializableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 如果A未实现Serializable接口，那么会序列化失败
        A a = new A();
        a.setId(1);
        a.setName("wc");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\a.dat"));
        oos.writeObject(a);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("d:\\a.dat"));
        A aa = (A)in.readObject();
        System.out.println(a.getName());


    }
}
