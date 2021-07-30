package com.mk.demos.mapstruct.complex.jdefault;

import java.util.function.Function;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * DO:{ price, discount} -> VO:{ price, discount, disPrice}
 *
 * @author WangChen
 * Created on 2021/7/30 13:59
 * @since 0.1
 */
@Mapper
public interface FuncMapper {

    FuncMapper INSTANCE = Mappers.getMapper(FuncMapper.class);

    AppleVO toAppleVO(Apple apple);

//    AppleVO toAppleVO(Apple apple, @Context Function<Apple, AppleVO> mapper);

    default<T, R> AppleVO toAppleVO(Apple apple, Function<Apple, Double> mapper){
        AppleVO appleVO = toAppleVO(apple);
        appleVO.setDiscountPrice(mapper.apply(apple));
        return appleVO;
    }

}
