package com.mk.demos.spring.databinding;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mk.demos.spring.model.Company;
import com.mk.demos.spring.model.Employee;

/**
 * BeanWrapper 示例
 *
 * @author WangChen
 * Created on 2021/4/22 18:58
 * @since 1.0
 */
public class BeanWrapperTest {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.refresh();

        BeanWrapper company = new BeanWrapperImpl(new Company());
        // setting the company name..
        company.setPropertyValue("name", "Some Company Inc.");
        System.out.println("1:" + company.getPropertyValue("name"));
        // ... can also be done like this:
        PropertyValue value = new PropertyValue("name", "Some Company Inc.");
        company.setPropertyValue(value);
        System.out.println("2:" + company.getPropertyValue("name"));

        // ok, let's create the director and tie it to the company:
        BeanWrapper jim = new BeanWrapperImpl(new Employee());
        jim.setPropertyValue("name", "Jim Stravinsky");
        company.setPropertyValue("managingDirector", jim.getWrappedInstance());
        System.out.println("managingDirector: " + company.getPropertyValue("managingDirector"));

        // retrieving the salary of the managingDirector through the company
        Float salary = (Float) company.getPropertyValue("managingDirector.salary");
        System.out.println(salary);
    }
}
