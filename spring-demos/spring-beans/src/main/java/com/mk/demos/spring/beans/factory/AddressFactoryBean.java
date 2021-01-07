package com.mk.demos.spring.beans.factory;

import org.springframework.beans.factory.FactoryBean;

import com.mk.demos.spring.beans.domain.Address;

/**
 * address FactoryBean
 *
 * @author WangChen
 * Created on 2021/1/7 21:13
 * @since 1.0
 */
public class AddressFactoryBean implements FactoryBean<Address> {

    @Override
    public Address getObject()  {
        return Address.createAddress();
    }

    @Override
    public Class<?> getObjectType() {
        return Address.class;
    }
}
