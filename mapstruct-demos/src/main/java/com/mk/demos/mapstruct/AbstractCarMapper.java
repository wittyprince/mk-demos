package com.mk.demos.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Abstract CarMapper
 *
 * @author WangChen
 * Created on 2021/7/29 15:43
 * @since 0.1
 */
@Mapper
public abstract class AbstractCarMapper {

    public static final AbstractCarMapper INSTANCE = Mappers.getMapper( AbstractCarMapper.class );

    @Mapping(source = "numberOfSeats", target = "seatCount")
    public abstract CarDto carToCarDto(Car car);

    public PersonDto personToPersonDto(Person person) {
        //hand-written mapping logic
        return null;
    }
}
