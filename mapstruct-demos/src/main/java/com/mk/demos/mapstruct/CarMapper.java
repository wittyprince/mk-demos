package com.mk.demos.mapstruct;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * CarMapper
 *
 * @author WangChen
 * Created on 2021/7/22 13:45
 * @since 0.1
 */
@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car);

    default PersonDto personToPersonDto(Person person) {
        //hand-written mapping logic
        return null;
    }

    @Mapping(source = "seatCount", target = "numberOfSeats")
    void updateCarFromDto(CarDto carDto, @MappingTarget Car car);

    /**
     * This allows for fluent invocations of mapping methods.
     */
    @InheritInverseConfiguration
    Car updateCarFromDto2(CarDto carDto, @MappingTarget Car car);
}
