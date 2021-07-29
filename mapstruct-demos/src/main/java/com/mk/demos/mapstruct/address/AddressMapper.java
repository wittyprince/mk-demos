package com.mk.demos.mapstruct.address;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mk.demos.mapstruct.Person;

/**
 * AddressMapper
 *
 * @author WangChen
 * Created on 2021/7/29 15:54
 * @since 0.1
 */
@Mapper
public interface AddressMapper {

    @Mapping(target = "description", source = "person.description")
    @Mapping(target = "houseNumber", source = "address.houseNo")
    DeliveryAddressDto personAndAddressToDeliveryAddressDto(Person person, Address address);

    @Mapping(target = "description", source = "person.description")
    @Mapping(target = "houseNumber", source = "hn")
    DeliveryAddressDto personAndAddressToDeliveryAddressDto(Person person, Integer hn);
}
