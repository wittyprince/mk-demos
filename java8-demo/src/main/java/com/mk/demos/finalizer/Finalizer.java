package com.mk.demos.finalizer;

/**
 * finalizer
 * 指的是继承自java.lang.Object.finalize()的方法
 * 注意: 谨慎使用
 * 参考: https://www.baeldung.com/java-finalize
 *
 * @author WangChen
 * Created on 2019/12/15 13:28
 * @since 1.0
 */
public class Finalizer {

    protected void finalize() throws Throwable { }
}
