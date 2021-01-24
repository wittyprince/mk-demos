package com.mk.demos.design.pattern.strategy.discount;

import java.math.BigDecimal;
import java.util.Comparator;

/**
 * 测试类
 *
 * @author WangChen
 * Created on 2021/1/23 19:34
 * @since 1.0
 */
public class Client {

    public static void main(String [] args){
        BigDecimal price = new BigDecimal("120");
        GoodsDto goodsDto = new GoodsDto();
        goodsDto.setPrice(price);

        Discount mjDiscount = new MjDiscount();
        Discount zkDiscount = new ZkDiscount();
        zkDiscount.discount(goodsDto);
        mjDiscount.discount(goodsDto);
        System.out.println(goodsDto.getPrice());
        Comparable c ;
        Comparator cc;

    }
}
