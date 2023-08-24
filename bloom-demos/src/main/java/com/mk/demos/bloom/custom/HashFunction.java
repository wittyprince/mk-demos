package com.mk.demos.bloom.custom;

/**
 * HashFunction
 *
 * @author WangChen
 * Created on 2022/2/17
 * @since 0.1
 */
public class HashFunction {

    private int size;
    private int seed;

    public HashFunction(int size, int seed) {
        this.size = size;
        this.seed = seed;
    }

    public int hash(String value) {
        int result = 0;
        int len = value.length();
        for (int i = 0; i < len; i++) {
            result = seed * result + value.charAt(i);
        }
//        int r = (size - 1) & result;
//        System.out.println("seed: " + seed + ";" + value + " : " + r);
        return (size - 1) & result;
    }

    public static void main(String[] args) {
        HashFunction function = new HashFunction(16, 8);
        String s = "w";
        int hashCode = s.hashCode();
        System.out.println(hashCode);
        int hash = function.hash(s);
        System.out.println(hash);
    }
}
