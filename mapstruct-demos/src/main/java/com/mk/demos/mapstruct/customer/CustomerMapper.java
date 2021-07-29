package com.mk.demos.mapstruct.customer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * CustomerMapper
 *
 * @author WangChen
 * Created on 2021/7/29 16:09
 * @since 0.1
 */
@Mapper
public interface CustomerMapper {

    @Mapping( target = "name", source = "record.name" )
    @Mapping( target = ".", source = "record" )
    @Mapping( target = ".", source = "account" )
    Customer customerDtoToCustomer(CustomerDto customerDto);

}
