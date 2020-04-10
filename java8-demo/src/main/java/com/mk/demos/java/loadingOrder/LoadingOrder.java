package com.mk.demos.java.loadingOrder;

/**
 * 静态代码块、构造代码块、构造函数以及Java类初始化顺序
 * https://www.cnblogs.com/Qian123/p/5713440.html
 *
 * 对于一个类而言，按照如下顺序执行：
 * 执行静态代码块
 * 执行构造代码块
 * 执行构造函数
 *
 * 对于静态变量、静态初始化块、变量、初始化块、构造器，它们的初始化顺序依次是:
 * （静态变量、静态初始化块）>（变量、初始化块）>构造器。
 *
 * @author WangChen
 * Created on 2020/4/10 20:08
 * @since 1.0
 */
public class LoadingOrder {

    private String s1 = "str";

    /**
     * 构造函数
     *
     * 1. 对象一建立，就会调用与之相应的构造函数，也就是说，不建立对象，构造函数时不会运行的
     * 2. 构造函数的作用是用于给对象进行初始化
     * 3. 一个对象建立，构造函数只运行一次，而一般方法可以被该对象调用多次。
     */
    public LoadingOrder() {
        System.out.println("1 constructor");
    }

    public LoadingOrder(String s1) {
        this.s1 = s1;
        System.out.println("2 constructor");
    }

    /**
     * 构造代码块：类中直接用{}定义，每一次创建对象时执行。
     *
     * 1. 构造代码块的作用是给对象进行初始化。
     * 2. 对象一建立就运行构造代码块了，而且优先于构造函数执行。
     * 这里要强调一下，有对象建立，才会运行构造代码块，类不能调用构造代码块的，
     * 而且构造代码块与构造函数的执行顺序是前者先于后者执行。
     * 3. 构造代码块与构造函数的区别是：
     * 构造代码块是给所有对象进行统一初始化，而构造函数是给对应的对象初始化，
     * 因为构造函数是可以多个的，运行哪个构造函数就会建立什么样的对象，
     * 但无论建立哪个对象，都会先执行相同的构造代码块。
     * 也就是说，构造代码块中定义的是不同对象共性的初始化内容。
     *
     */
    {
        System.out.println("3 block");
    }

    /**
     * 静态代码块：用static声明，jvm加载类时执行，仅执行一次
     *
     * 1. 它是随着类的加载而执行，只执行一次，并优先于主函数。具体说，静态代码块是由类调用的。
     * 类调用时，先执行静态代码块，然后才执行主函数的。
     * 2. 静态代码块其实就是给类初始化的，而构造代码块是给对象初始化的。
     * 3. 静态代码块中的变量是局部变量，与普通函数中的局部变量性质没有区别。
     * 4. 一个类中可以有多个静态代码块
     */
    static {
        System.out.println("4 static block");
    }

    /**
     * 执行顺序优先级：静态块,main(),构造块,构造方法。
     */
    public static void main(String [] args){
        System.out.println("5 main");
        LoadingOrder loadingOrder1 = new LoadingOrder();
        LoadingOrder loadingOrder2 = new LoadingOrder("loading2");
        /**
         * 运行main方法后执行顺序为:
         * 4 static block
         * 5 main
         * 3 block
         * 1 constructor
         * 3 block
         * 2 constructor
         */

    }
}
