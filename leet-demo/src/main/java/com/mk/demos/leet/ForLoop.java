package com.mk.demos.leet;

/**
 * for loop i++ vs ++i
 *
 * @author WangChen
 * Created on 2019/11/28 18:43
 * @since 1.0
 */
public class ForLoop {

    public static void main(String[] args){
        new ForLoop().loop1();
    }

    private void loop1(){
        int i;
        for (i=3; i < 5; i++){
            System.out.println(i);
        }
        System.out.println(i);
        // 3  4  5
    }

    private void loop2(){
        int i;
        for (i=3; i < 5; ++i){
            System.out.println(i);
        }
        System.out.println(i);
        // 3  4  5
    }

    private void loop3(){
        int i;
        int n = 0;
        for (i=3; n < 5; n = i++){
            System.out.println(i);
        }
        System.out.println(i);
        // 3  4  5 6
    }

    private void loop4(){
        int i;
        int n = 0;
        for (i=3; n < 5; n = ++i){
            System.out.println(i);
        }
        System.out.println(i);
        // 3  4  5
    }
}
