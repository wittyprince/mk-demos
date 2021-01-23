package com.mk.demos.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Java反射机制：
 * 什么是反射？
 * 主要是指程序可以访问、检测和修改它本身状态或行为的一种能力。
 * 反射就是在运行时才知道要操作的类是什么，并且可以在运行时获取类的完整构造，
 * 并调用对应的方法。
 * 好处：
 * 根据配置类名(如文件信息中的信息)，动态加载某个类，如spring中的bean定义
 * 如果没有反射，对于外部类的私有成员，我们将一筹莫展，所以我们有了反射这一后门，
 * 为程序设计提供了更大的灵活性。工具本身并没有错，关键在于如何正确地使用。
 * <p>
 * 1.如何反射获取 Class 对象？
 * 2.如何反射获取类中的所有字段？
 * 3.如何反射获取类中的所有构造方法？
 * 4.如何反射获取类中的所有非构造方法？
 *
 * @author WangChen
 * Created on 2021/1/22 20:49
 * @since 1.0
 */
public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException {
        // 1.如何反射获取 Class 对象？
        // 1.1 Class.forName(classname)
        String classname = "com.mk.demos.java.reflection.ReflectionModel";
        Class<?> clazz1 = Class.forName(classname);
        // 1.2 通过类的class属性
        // 第二种方法有限制条件：需要导入类的包
        Class<ReflectionModel> clazz2 = ReflectionModel.class;
        // 1.3 通过对象的getClass()函数
        // 第三种方法已经有了 Student 对象，不再需要反射。
        ReflectionModel model = new ReflectionModel();
        Class<? extends ReflectionModel> clazz3 = model.getClass();

        // 通过这三种方式获取到的 Class 对象是同一个，
        // 也就是说 Java 运行时，每一个类只会生成一个 Class 对象。
        System.out.println(clazz1 == clazz2); // true
        System.out.println(clazz1 == clazz3); // true

        // 2.如何反射获取类中的所有字段？
        // 获取成员变量
        // getDeclaredFields获取所有声明的字段，包括公有字段和私有字段
        Field[] declaredFields = clazz1.getDeclaredFields();
//        Arrays.stream(declaredFields).forEach(System.out::println);
        for (Field f : declaredFields) {
            System.out.println("declaredField: " + f);
        }
        // getFields仅用来获取公有字段
        Field[] fields = clazz1.getFields();
//        Arrays.stream(fields).forEach(System.out::println);
        for (Field f : fields) {
            System.out.println("field: " + f);
        }
        System.out.println("-------------------------------------");
        // 3.如何反射获取类中的所有构造方法？
        // getDeclaredConstructors获取所有声明的构造方法
        Constructor<?>[] declaredConstructors = clazz1.getDeclaredConstructors();
        for (Constructor c : declaredConstructors){
            System.out.println("declaredConstructor: " + c);
        }
        // getConstructors获取所有公有的构造方法
        Constructor<?>[] constructors = clazz1.getConstructors();
        for (Constructor c : constructors){
            System.out.println("constructor: " + c);
        }
        System.out.println("-------------------------------------");
        // 4.如何反射获取类中的所有非构造方法？
        Method[] declaredMethods = clazz1.getDeclaredMethods();
        for (Method m : declaredMethods){
            System.out.println("declaredMethod : " + m);
        }
        Method[] methods = clazz1.getMethods();
        for (Method m : methods){
            System.out.println("method: " + m);
        }
        System.out.println("-------------------------------------");
        //
        try {
            // private方法需使用getDeclaredMethod
            Method m = clazz1.getDeclaredMethod("privateMethod", String.class);
            System.out.println("Method m :" + m);
            // 如果是私有的函数，需要设置setAccessible=true使其可使用，公有的函数则不需
            m.setAccessible(true);
            m.invoke(clazz1.newInstance(), "sss");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------------");
        // 通过反射创建类对象,主要有两种方式：
        // 一是：通过 Class 对象的 newInstance() 方法
        // 二是：通过 Constructor 对象的 newInstance() 方法。
        // 通过 Constructor 对象创建类对象可以选择特定构造方法，
        // 而通过 Class 对象则只能使用默认的无参数构造方法。

    }
}

