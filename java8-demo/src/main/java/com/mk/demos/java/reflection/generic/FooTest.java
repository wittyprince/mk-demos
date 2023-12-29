package com.mk.demos.java.reflection.generic;

import com.mk.demos.java.reflection.generic.model.foo.Bar;
import com.mk.demos.java.reflection.generic.model.foo.Foo;
import com.mk.demos.java.reflection.generic.model.foo.FooChild;

/**
 * foo test
 *
 * @author WangChen
 * Created on 2022/10/24
 * @since 1.0
 */
public class FooTest {

    private Foo<Bar> foo = new FooChild();

    public static void main(String[] args) {
        ReflectionUtil.getClassName(null);
    }
}
