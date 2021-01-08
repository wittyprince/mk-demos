package com.mk.demos.spring.beans.factory;

import com.mk.demos.spring.beans.domain.Address;

/**
 * address 工厂类
 *
 * @author WangChen
 * Created on 2021/1/7 20:55
 * @since 1.0
 */
public interface AddressFactory {

    default Address createAddress(){
        return Address.createAddress();
    }

    default void initByCustom(){
        System.out.println("initByCustom");
    }
}
