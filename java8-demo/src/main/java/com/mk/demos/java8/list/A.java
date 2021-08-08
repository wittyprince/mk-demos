package com.mk.demos.java8.list;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * a
 *
 * @author WangChen
 * Created on 2021/8/8 13:00
 * @since 0.1
 */
public class A {

    private int i1;                 // 原始类型
    private Integer i2;             // 包装类型

    private String s1;              // 引用类型 String

    private Boolean bool;
    private boolean bool2;

    private B b;                    // 引用类型 B

    private List<B> bList;          // 集合Collection的List类型

    private Map<String, B> bMap;    // Map类型

    private B[] bArray;             // 数组

    // ---getter & setter---
    public int getI1() {
        return i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }

    public Integer getI2() {
        return i2;
    }

    public void setI2(Integer i2) {
        this.i2 = i2;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    public boolean isBool2() {
        return bool2;
    }

    public void setBool2(boolean bool2) {
        this.bool2 = bool2;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public List<B> getbList() {
        return bList;
    }

    public void setbList(List<B> bList) {
        this.bList = bList;
    }

    public Map<String, B> getbMap() {
        return bMap;
    }

    public void setbMap(Map<String, B> bMap) {
        this.bMap = bMap;
    }

    public B[] getbArray() {
        return bArray;
    }

    public void setbArray(B[] bArray) {
        this.bArray = bArray;
    }
}
