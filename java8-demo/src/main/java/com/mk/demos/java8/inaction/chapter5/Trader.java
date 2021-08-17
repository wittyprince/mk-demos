package com.mk.demos.java8.inaction.chapter5;

/**
 * Trader
 *
 * @author WangChen
 * Created on 2019/12/17 7:36
 * @since 1.0
 */
public class Trader {

    private final String name;
    private final String city;

    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }

    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }

    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }

}
