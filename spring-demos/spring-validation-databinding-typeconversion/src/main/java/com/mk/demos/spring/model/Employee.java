package com.mk.demos.spring.model;

/**
 * Employee
 *
 * @author WangChen
 * Created on 2021/4/22 19:00
 * @since 1.0
 */
public class Employee {
    private String name;

    private float salary;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
