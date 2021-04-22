package com.mk.demos.spring.model;

/**
 * Company
 *
 * @author WangChen
 * Created on 2021/4/22 19:00
 * @since 1.0
 */
public class Company {

    private String name;
    private Employee managingDirector;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManagingDirector() {
        return this.managingDirector;
    }

    public void setManagingDirector(Employee managingDirector) {
        this.managingDirector = managingDirector;
    }
}
