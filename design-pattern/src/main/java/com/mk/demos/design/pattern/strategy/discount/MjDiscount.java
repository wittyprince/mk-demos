package com.mk.demos.design.pattern.strategy.discount;

import java.math.BigDecimal;

/**
 * 满减活动
 *
 * @author WangChen
 * Created on 2021/1/23 19:19
 * @since 1.0
 */
public class MjDiscount implements Discount{

    MjRules mjRules = new MjRules(new BigDecimal("100"), new BigDecimal("10"));

    @Override
    public void discount(GoodsDto goodsDto) {
        BigDecimal price = goodsDto.getPrice();
        if (price.compareTo(mjRules.getAchievePrice()) >= 0){
            goodsDto.setPrice(price.subtract(mjRules.getDiscountPrice()));
        }
    }
}
