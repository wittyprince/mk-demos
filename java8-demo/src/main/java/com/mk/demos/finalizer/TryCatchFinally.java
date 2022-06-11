package com.mk.demos.finalizer;

/**
 * finalizer
 * 注意 不建议在finally中使用return
 *
 * try...catch...finally...语句块执行顺序:
 *  1 先执行 try 块
 *  2 如果try块中无异常信息, 则执行finally,
 *      2.1.1 如果finally中无return, 则执行try块中return或try...catch...finally...块外的最后的return语句返回。
 *      即 divide1()中 为 ① -> ③ -> ⑤, divide2()中为①->③->④->⑧
 *      2.1.2 如果finally块中有return, 那么执行到finally中return时，直接返回，不会再执行try块或catch块中的return
 *      即divide3()中为①->③->⑦, divide4()中也为①->③->⑦,
 *  3 如果try块中有异常, 则执行catch块
 *      divide3()中为①->②->③->⑦, divide4()中也为①->②->③->⑦, divide5()中为①->②->③->⑥,
 *      divide2()中为①->②->③->④->⑧,
 *
 * @author WangChen
 * Created on 2019/12/15 9:47
 * @since 1.0
 */
public class TryCatchFinally {

    public double divide1(int a, int b){
        try {
            System.out.println("① a/b :" + a / b);// ①
            return a / b;// ⑤
        }catch (Exception e){
            System.out.println("② catch 语句块: ");// ②
//            return a + 1;// ⑥
        }finally {
            System.out.println("③ finally 语句块: ");// ③
//            return a + 2;// ⑦
        }
        System.out.println("④ Out of try-catch-finally");// ④
        return -1;// ⑧
    }

    public int divide2(int a, int b){
        try {
            System.out.println("a/b :" + a / b + "--- ①");// ①
//            return a / b;// ⑤
        }catch (Exception e){
            System.out.println("catch 语句块: --- ②");// ②
//            return a + 1;// ⑥
        }finally {
            System.out.println("finally 语句块: --- ③");// ③
//            return a + 2;// ⑦
        }
        System.out.println("Out of try-catch-finally --- ④");// ④
        return -1;// ⑧
    }

    public int divide3(int a, int b){
        try {
            System.out.println("a/b :" + a / b + "--- ①");// ①
            return a / b;// ⑤
        }catch (Exception e){
            System.out.println("catch 语句块: --- ②");// ②
//            return a + 1;// ⑥
        }finally {
            System.out.println("finally 语句块: --- ③");// ③
            return a + 2;// ⑦
        }
//        System.out.println("Out of try-catch-finally --- ④");// ④  //此句为 Unreachable statement, 所以不注释掉会报错
//        return -1;// ⑧
    }

    public int divide4(int a, int b){
        try {
            System.out.println("a/b :" + a / b + "--- ①");// ①
            return a / b;// ⑤
        }catch (Exception e){
            System.out.println("catch 语句块: --- ②");// ②
            return a + 1;// ⑥
        }finally {
            System.out.println("finally 语句块: --- ③");// ③
            return a + 2;// ⑦
        }
//        System.out.println("Out of try-catch-finally --- ④");// ④
//        return -1;// ⑧
    }

    public int divide5(int a, int b){
        try {
            System.out.println("a/b :" + a / b + "--- ①");// ①
            return a / b;// ⑤
        }catch (Exception e){
            System.out.println("catch 语句块: --- ②");// ②
            return a + 1;// ⑥
        }finally {
            System.out.println("finally 语句块: --- ③");// ③
//            return a + 2;// ⑦
        }
//        System.out.println("Out of try-catch-finally --- ④");// ④ //此句为 Unreachable statement, 所以不注释掉会报错
//        return -1;// ⑧
    }

    public static void main(String [] args){
        TryCatchFinally finalizer2 = new TryCatchFinally();
//        System.out.println("商是: " + finalizer2.divide1(9, 1));
//        System.out.println("商是: " + finalizer2.divide2(9, 1));
//        System.out.println("商是: " + finalizer2.divide3(9, 1));
//        System.out.println("商是: " + finalizer2.divide4(9, 1));
//        System.out.println("商是: " + finalizer2.divide2(9, 0));

        try {
            // do something
            System.out.println("try");
            System.exit(0);// status=0 表示jvm正常退出
        } finally{
            System.out.println("Print from finally");// 注意此行语句不会执行
        }

        try {
            // do something
            System.out.println("try");
            System.exit(1);// status非零表示jvm非正常退出
        } finally{
            System.out.println("Print from finally");// 注意此行语句不会执行
        }

        try {
            // do something
            System.out.println("try");
//            System.exit(1);
            return;
        } finally{
            System.out.println("Print from finally");// 注意此行语句会执行
        }
    }
}
