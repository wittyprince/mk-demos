package com.mk.demos.java8.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;

/**
 * list 工具类
 *
 * @author WangChen
 * Created on 2021/8/8 12:07
 * @since 0.1
 */
public class ListUtils {

    /**
     * 使用predicate比较两个list是否相等，
     * 好处是避免重定义对象自身的equals方法，因为Object.equals方法只能有一个，且需要重写hashcode方法。
     * 另外，如果某一对象比较的维度有多个时，如业务1：按照T的属性1来比较，业务2：按照T的属性2来比较。
     * 这时，一个equals显然不能满足多业务场景的情况。此时可以考虑使用comparable比较器
     * 注意这种比较方式是顺序比较，且 predicate不能为空
     */
    public static <T> boolean equals(List<T> list1, List<T> list2, BiPredicate<T, T> predicate) {
        if (predicate == null){
            throw new RuntimeException("predicate is null.");
        }
        if (list1 == list2) { // 包含 list1, list2 都为 null 的情况
            return true;
        }
        if (list1 == null || list2 == null || list1.size() != list2.size()) {
            return false;
        }
        Iterator<T> it1 = list1.iterator();
        Iterator<T> it2 = list2.iterator();
        T t1;
        T t2;
        while (it1.hasNext() && it2.hasNext()){
            t1 = it1.next();
            t2 = it2.next();
            if (!(t1 == null ? t2 == null : predicate.test(t1, t2)/*next1.equals(next2)*/)) {
                return false;
            }
        }
        return true /*!(it1.hasNext() || it2.hasNext())*/;
    }


    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        a2.setI1(2);
        A a3 = new A();
        a3.setI1(2);
        List<A> list1 = new ArrayList<>();
        list1.add(a1);
        list1.add(a2);
        List<A> list2 = new ArrayList<>();
        list2.add(a1);
        list2.add(a3);

        boolean equals = equals(list1, list2, (x, y) -> (x == y) || (x != null && aEquals(x, y)));
        System.out.println(equals);
    }

    private static boolean aEquals(A x, A y){
        if (x == y) return true;
        if (y == null) return false;
        return x.getI1() == y.getI1() && x.isBool2() == y.isBool2() && Objects.equals(x.getI2(), y.getI2())
                && Objects.equals(x.getS1(), y.getS1()) && Objects.equals(x.getBool(), y.getBool())
                && /*Objects.equals(x.getB(), y.getB())*/ bEquals(x.getB(), y.getB())
                && Objects.equals(x.getbList(), y.getbList())
                && Objects.equals(x.getbMap(), y.getbMap())
                && Arrays.equals(x.getbArray(), y.getbArray());
    }

    private static boolean bEquals(B x, B y){
        if (x == y) return true;
        if (y == null) return false;
        return x.getI1() == y.getI1()
                && Objects.equals(x.getS1(), y.getS1());
    }

}
