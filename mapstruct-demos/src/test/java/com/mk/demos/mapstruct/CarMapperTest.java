package com.mk.demos.mapstruct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * CarMapperTest
 *
 * @author WangChen
 * Created on 2021/7/22 13:47
 * @since 0.1
 */
public class CarMapperTest {

    @Test
    public void test(){
        //given
        Car car = new Car( "Morris", 5, CarType.AUDI );

        //when
        CarMapper carMapper = CarMapper.INSTANCE;
        CarDto carDto = carMapper.carToCarDto( car );

        //then
        Assertions.assertNotNull(carDto);
        Assertions.assertEquals("Morris", carDto.getMake());
        Assertions.assertEquals(5, carDto.getSeatCount());
        Assertions.assertEquals("AUDI", carDto.getType());
    }

    @Test
    public void test2(){
        Car car = new Car( "Morris", 5, CarType.AUDI );

        AbstractCarMapper carMapper = AbstractCarMapper.INSTANCE;
        CarDto carDto = carMapper.carToCarDto( car );

        Assertions.assertNotNull(carDto);
        Assertions.assertEquals("Morris", carDto.getMake());
        Assertions.assertEquals(5, carDto.getSeatCount());
        Assertions.assertEquals("AUDI", carDto.getType());
    }
}
