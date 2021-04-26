package com.mk.demos.spring.format;

import java.time.LocalDate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mk.demos.spring.model.Student;

/**
 * 使用Formatter
 *
 * @author WangChen
 * Created on 2021/4/23 21:22
 * @since 1.0
 */
public class FormattingConversionServiceByXmlTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        String location = "META-INF/format-context.xml";
        context.setConfigLocation(location);

        context.refresh();

        Student student = context.getBean(Student.class);
        System.out.println(student.getBirthday());

        context.close();

        System.out.println( LocalDate.now());
    }
}
