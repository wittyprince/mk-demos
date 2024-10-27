package com.mk.demos.java.jstatic;

/**
 * StaticClassA
 *
 * @author WangChen
 * Created on 2024/10/27
 * @since 1.0
 */
public /*static*/ class ClassA { // static 不能用在外部类上
    private String nameA = "ClassA";
    private static String staticNameA = "ClassA";

    public void mA() {
        System.out.println("mA");
    }
    public static void staticMA() {
        System.out.println("staticMA");
    }

    // static 只能用在内部类上
    public static class StaticNestedClassB {
        private String nameB = "StaticNestedClassB";
        private static String staticName = "StaticNestedClassB";

        public void mB() {
            System.out.println("mB");
        }

        public static void staticMB() {
            System.out.println("staticMB");
        }
    }

    public class InnerClassC {
        private String nameC = "InnerClassC";
        // private static String staticNameC; // 非静态内部类不能有静态成员
        private String innerName = ClassA.this.nameA;

        public void mC() {
            System.out.println("mC");
        }
//         public static void staticMC() { // 非静态内部类不能有静态方法
//             System.out.println("staticMC");
//         }
    }

    public static void main(String[] args) {
        // StaticClassA.InnerClassC innerClassC = new StaticClassA.InnerClassC(); // 非静态内部类不能直接创建
        ClassA classA = new ClassA();
        System.out.println(classA.nameA);
        System.out.println(classA.staticNameA);
        System.out.println(ClassA.staticNameA);


        ClassA.InnerClassC innerClassC = classA.new InnerClassC();
        System.out.println(innerClassC.nameC);
        System.out.println(innerClassC.innerName);
        System.out.println(innerClassC.nameC);

        ClassA.StaticNestedClassB staticNestedClassB = new ClassA.StaticNestedClassB();
        System.out.println(staticNestedClassB.nameB);
        // Non-static field 'nameB' cannot be referenced from a static context
        // System.out.println(StaticNestedClassB.nameB);
        System.out.println(StaticNestedClassB.staticName);
    }
}
