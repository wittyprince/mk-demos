package com.mk.demos.java.reflection.generic.model.foo;

/**
 * foo
 *
 * @author WangChen
 * Created on 2022/10/24
 * @since 1.0
 */
public abstract class Foo<T> {
    private Class<T> tClass;

    public Foo(Class<T> tClass) {
        this.tClass = tClass;
    }
    //content
}
