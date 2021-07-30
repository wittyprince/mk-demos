package com.mk.demos.mapstruct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mk.demos.mapstruct.complex.jdefault.Apple;
import com.mk.demos.mapstruct.complex.jdefault.AppleVO;
import com.mk.demos.mapstruct.complex.jdefault.FuncMapper;

/**
 * FuncMapper test
 *
 * @author WangChen
 * Created on 2021/7/30 14:06
 * @since 0.1
 */
public class FuncMapperTest {

    @Test
    public void test(){
        FuncMapper mapper = FuncMapper.INSTANCE;
        Apple apple = new Apple(6.0, 0.75);
        AppleVO appleVO = mapper.toAppleVO(apple);
        System.out.println(appleVO);
        Assertions.assertNotNull(appleVO);
        Assertions.assertNull(appleVO.getDiscountPrice());
        System.out.println("--------------------");

        AppleVO appleVO2 = mapper.toAppleVO(apple, a -> a.getPrice() * a.getDiscount());
        System.out.println(appleVO2);
        Assertions.assertNotNull(appleVO2);
        Assertions.assertEquals(4.5, appleVO2.getDiscountPrice());
    }
}
