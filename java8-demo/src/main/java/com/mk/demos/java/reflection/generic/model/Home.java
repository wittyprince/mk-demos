package com.mk.demos.java.reflection.generic.model;

import java.util.List;

/**
 * 家庭
 * T: 家庭中拥有的车
 *
 * @author WangChen
 * Created on 2022/10/19
 * @since 1.0
 */
public class Home<T> {

    private int int1;
    private Integer integer1;

    private String name;

    private T t;
    private List<T> tList;
}
