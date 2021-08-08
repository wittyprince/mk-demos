package com.mk.demos.java.jclass.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * field test
 *
 * @author WangChen
 * Created on 2021/8/8 18:13
 * @since 0.1
 */
public class FieldTest {

    public static void main(String [] args){
        Field[] declaredFields = A.class.getDeclaredFields();
        System.out.println(declaredFields.length);
        Arrays.stream(declaredFields).forEach(
                f -> {
                    String name = f.getName(); // field name
                    Class<? extends Field> fClass = f.getClass(); // java.lang.reflect.Field
                    Class<?> declaringClass = f.getDeclaringClass(); // com.mk.demos.java8.list.A
                    int modifiers = f.getModifiers(); //
                    Class<?> type = f.getType(); // class java.lang.Integer
                    AnnotatedType annotatedType = f.getAnnotatedType();
                    Annotation[] annotations = f.getAnnotations();
                    Annotation[] declaredAnnotations = f.getDeclaredAnnotations();
                    Type genericType = f.getGenericType();
                    boolean synthetic = f.isSynthetic();
                    boolean primitive = f.getType().isPrimitive();
                    System.out.println(
                            "name: " + name + ";\n" +
                            "fClass: " + fClass.getName() + ";\n" +
                            "declaringClass: " + declaringClass.getName() + ";\n" +
                            "modifiers: " + modifiers + ";\n" +
                            "type: " + type + ";\n" +
                            "annotatedType: " + annotatedType.getType() + ";"
                    );
                    System.out.println("---------------------");
                }
        );
    }
}
