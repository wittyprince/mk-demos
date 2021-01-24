package com.mk.demos.design.pattern.strategy.discount;

import java.math.BigDecimal;

/**
 * 折扣活动
 *
 * @author WangChen
 * Created on 2021/1/23 19:30
 * @since 1.0
 */
public class ZkDiscount implements Discount{

    private ZkRules zkRules = new ZkRules(new BigDecimal("100"), new BigDecimal("0.9"));
    @Override
    public void discount(GoodsDto goodsDto) {
        BigDecimal price = goodsDto.getPrice();
        if (price.compareTo(zkRules.getAchievePrice()) >= 0){
            goodsDto.setPrice(price.multiply(zkRules.getDiscount()));
        }
    }
}
