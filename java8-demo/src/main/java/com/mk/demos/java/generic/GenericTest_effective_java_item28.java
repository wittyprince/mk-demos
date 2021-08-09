package com.mk.demos.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * GenericTest_effective_java_item28
 *
 * list 优于数组
 *
 * @author WangChen
 * Created on 2021/8/9 16:07
 * @since 0.1
 */
public class GenericTest_effective_java_item28 {

    // list 优于数组
    // 数组与泛型有两个重要区别:
    // 1. 数组是协变的: 如果 Sub 是 Super 的一个子类型，那么数组类型 Sub[] 就是数组类型 Super[] 的一个子类型.
    //    泛型是不变的: 对于任何两个不同类型 Type1 和 Type2，List<Type1> 既不是 List<Type2> 的子类型，也不是 List<Type2> 的超类型
    // 你可能认为这意味着泛型是有缺陷的，但可以说数组才是有缺陷的

    void test1(){
        // Fails at runtime!
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in"; // Throws ArrayStoreException

        // Won't compile!
//        List<Object> ol = new ArrayList<Long>(); // Incompatible types
//        ol.add("I don't fit in");


    }

    // 2. 数组是具体化的
    //    这意味着数组在运行时知道并强制执行他们的元素类型。
    //      如前所述，如果试图将 String 元素放入一个 Long 类型的数组中，就会得到 ArrayStoreException。

    //    泛型是通过擦除来实现的 [JLS, 4.6]。这意味着它们只在编译时执行类型约束，并在运行时丢弃（或擦除）元素类型信息。

    // 由于这些基本差异，数组和泛型不能很好地混合。
    // 为什么创建泛型数组是非法的？因为这不是类型安全的。如果合法，编译器在其他正确的程序中生成的强制转换在运行时可能会失败，
    // 并导致 ClassCastException。这将违反泛型系统提供的基本保证。


    // 数组是协变的、具体化的；泛型是不变的和可被擦除的。

}
