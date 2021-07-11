package com.mk.demos.java8.lambda.FunctionalProgramming.exercise;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 第二章练习题
 * Java Lambdas - functional programming
 *
 * @author WangChen
 * Created on 2021/7/10 22:40
 * @since 0.1
 */
public class Chapter2 {

    public static void main(String [] args){

        // 1.b
        Function<Double, Double> negate = x -> -1 * x; // -1 * x vs -x ???
        Function<Double, Double> square = x -> x * x;
        Function<Double, Double> square_root = x -> x * x; // 开平方 ???

        // 1.c
        Function<Long, Long> c1 = x -> x + 1;
//        Function<Long, Long> c2 = (x, y) -> x + 1;
//        Function<Long, Boolean> c3 = x -> x == 1; // Long, Boolean 并不是 Long, Long

        // 2.b
        ThreadLocal<DateFormat> formatter1 = ThreadLocal.<DateFormat>withInitial(() -> new DateFormat() {
            @Override
            public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
                return null;
            }

            @Override
            public Date parse(String source, ParsePosition pos) {
                return null;
            }
        });

        ThreadLocal<DateFormat> formatter2 = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd-MMM-yyyy", Locale.US));
        System.out.println(formatter2.get().format(new Date(0)));
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(formatter2.get().format(cal.getTime()));

        ThreadLocal<DateFormat> formatter3 = ThreadLocal.withInitial(() -> DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.UK));
        System.out.println(formatter3.get().format(new Date(0)));

        // 3
        int xx = 6;
        if (check(a -> a > 6));
        check(x -> x > 5);

    }
//    static boolean check(Predicate<Integer> predicate){
//        return false;
//    }

    static boolean check(IntPred predicate){
        return false;
    }

}
