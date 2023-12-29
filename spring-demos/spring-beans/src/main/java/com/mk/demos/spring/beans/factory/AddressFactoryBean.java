package com.mk.demos.spring.beans.factory;

import com.mk.demos.spring.beans.domain.AAA;
import org.springframework.beans.factory.FactoryBean;

import com.mk.demos.spring.beans.domain.Address;

/**
 * address FactoryBean
 *
 * @author WangChen
 * Created on 2021/1/7 21:13
 * @since 1.0
 */
public class AddressFactoryBean implements FactoryBean {

    @Override
    public Address getObject()  {
        System.out.println("AddressFactoryBean#getObject...");
        return Address.createAddress();
    }

    @Override
    public Class<?> getObjectType() {
        System.out.println("AddressFactoryBean#getObjectType...");
        return AAA.class;
    }
}
