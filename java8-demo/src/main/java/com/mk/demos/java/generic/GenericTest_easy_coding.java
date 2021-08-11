package com.mk.demos.java.generic;

import java.util.ArrayList;
import java.util.List;

import com.mk.demos.java.generic.easy_coding.Animal;
import com.mk.demos.java.generic.easy_coding.Cat;
import com.mk.demos.java.generic.easy_coding.Garfield;

/**
 * 码出高效 中 关于泛型的示例
 *
 * 6.5 集合与泛型
 *
 * @author WangChen
 * Created on 2021/8/11 20:55
 * @since 0.1
 */
public class GenericTest_easy_coding {

    public static void main(String [] args){
        List<Cat> cats = new ArrayList<>();

        List<? super Cat> superCatFromCat = cats;
//        superCatFromCat.add(new Animal()); // 编译报错
        superCatFromCat.add(new Cat());
        superCatFromCat.add(new Garfield());
        Object object = superCatFromCat.get(0);

        List<? extends Cat> extendsCatFromCat = cats;
        Cat cat = extendsCatFromCat.get(0);
        Animal cat1 = extendsCatFromCat.get(0);
        extendsCatFromCat.add(new Garfield()); // 编译报错
        extendsCatFromCat.add(new Animal()); // 编译报错
        extendsCatFromCat.add(new Cat()); // 编译报错



    }
}
