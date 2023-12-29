package com.mk.demos.java.reflection.generic.model.foo;

/**
 * FooChild
 *
 * @author WangChen
 * Created on 2022/10/24
 * @since 1.0
 */
public class FooChild extends Foo<Bar> {
    public FooChild() {
        super(Bar.class);
    }
    //content
}
