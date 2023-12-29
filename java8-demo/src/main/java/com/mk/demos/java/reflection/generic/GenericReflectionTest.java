package com.mk.demos.java.reflection.generic;

import com.mk.demos.java.reflection.generic.model.Audi;
import com.mk.demos.java.reflection.generic.model.Car;
import com.mk.demos.java.reflection.generic.model.Home;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * 泛型的反射信息
 *
 * @author WangChen
 * Created on 2022/10/19
 * @since 1.0
 */
public class GenericReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Home<Car> homeCar = new Home<>();
        Home<Audi> homeAudi = new Home<>();

        String classname = "com.mk.demos.java.reflection.generic.model.Home";
        Class<?> clazz1 = Class.forName(classname);

        Package clazz1Package = clazz1.getPackage();
        System.out.println("package name: " + clazz1Package.getName());
//        Annotation[] clazz1PackageAnnotations = clazz1Package.getAnnotations();
//        Annotation[] declaredAnnotations = clazz1Package.getDeclaredAnnotations();
//        String implementationTitle = clazz1Package.getImplementationTitle();
//        String implementationVendor = clazz1Package.getImplementationVendor();
//        String implementationVersion = clazz1Package.getImplementationVersion();
//        String specificationTitle = clazz1Package.getSpecificationTitle();
//        String specificationVendor = clazz1Package.getSpecificationVendor();
//        String specificationVersion = clazz1Package.getSpecificationVersion();
//
//        String name = clazz1.getName();
//        System.out.println("name: " + name);
//
//        Annotation[] annotations1 = clazz1.getAnnotations();
//        AnnotatedType[] annotatedInterfaces = clazz1.getAnnotatedInterfaces();
//        AnnotatedType annotatedSuperclass = clazz1.getAnnotatedSuperclass();
//        Constructor<?>[] constructors = clazz1.getConstructors();
//        Type[] genericInterfaces = clazz1.getGenericInterfaces();
//        Type genericSuperclass = clazz1.getGenericSuperclass();
//        String typeName = clazz1.getTypeName();
        TypeVariable<? extends Class<?>>[] typeParameters = clazz1.getTypeParameters();
        for (TypeVariable tv : typeParameters) {
            System.out.println(tv.getName() + "-" + tv.getGenericDeclaration());
            Type[] bounds = tv.getBounds();
            AnnotatedType[] annotatedBounds = tv.getAnnotatedBounds();
        }

        Type genericSuperclass = clazz1.getGenericSuperclass();
        System.out.println("genericSuperclass: " + genericSuperclass);

        Field[] fields = clazz1.getFields();
        /*try {
            Field t = clazz1.getDeclaredField("t");
            Type tGenericType = t.getGenericType();

            Class<? extends Field> tClass = t.getClass();
            String tClassName = tClass.getName();

            Field tList = clazz1.getDeclaredField("tList");
            Class<? extends Field> tListClass = tList.getClass();
            String tListClassName = tListClass.getName();

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }*/


        Field[] declaredFields = clazz1.getDeclaredFields();




    }
}
