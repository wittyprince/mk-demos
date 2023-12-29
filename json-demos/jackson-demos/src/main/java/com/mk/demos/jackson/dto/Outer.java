package com.mk.demos.jackson.dto;

/**
 * outter
 *
 * @author WangChen
 * Created on 2022/10/18
 * @since 1.0
 */
public class Outer<T> {

    private T inner;
    private String name;

    public T getInner() {
        return inner;
    }

    public void setInner(T inner) {
        this.inner = inner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
