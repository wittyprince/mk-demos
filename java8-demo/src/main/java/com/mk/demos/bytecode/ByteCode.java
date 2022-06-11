package com.mk.demos.bytecode;

/**
 * 查看 .java 编译成的 .class 文件的 字节码
 * javap -p ByteCode.class
 * 使用 -verbose 参数可以查看详细信息
 *
 * ref:
 *      https://www.jianshu.com/p/d64a5dcccaa5
 *      https://www.cnblogs.com/GarfieldEr007/p/9943531.html
 *      https://xie.infoq.cn/article/866592b1bc8baa0e5911d6403
 *
 * @author WangChen
 * Created on 2022/6/11
 * @since 1.0.0
 */
public class ByteCode {

    private int m;

    public int inc() {
        return m + 1;
    }
}

/**
 * Compiled from "ByteCode.java"
 * public class com.mk.demos.bytecode.ByteCode {
 *   public com.mk.demos.bytecode.ByteCode();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public int inc();
 *     Code:
 *        0: aload_0
 *        1: getfield      #2                  // Field m:I
 *        4: iconst_1
 *        5: iadd
 *        6: ireturn
 * }
 *
 * Process finished with exit code 0
 */
