package com.mk.demos.java8.jinterface;

/**
 * class b implements interface a
 *
 * @author WangChen
 * Created on 2019/12/14 21:54
 * @since 1.0
 */
public class ClassB implements InterfaceA {

    @Override
    public void print() {

    }

    @Override
    public double plus(double d1, double d2) {
        return 0;
    }

    public double minus(double d1, double d2){
        return (int) (d1 - d2);
    }
}
