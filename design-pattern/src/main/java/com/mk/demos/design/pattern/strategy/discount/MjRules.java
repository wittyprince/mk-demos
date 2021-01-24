package com.mk.demos.design.pattern.strategy.discount;

import java.math.BigDecimal;

/**
 * 满减规则
 *
 * @author WangChen
 * Created on 2021/1/23 19:22
 * @since 1.0
 */
public class MjRules {

    private BigDecimal achievePrice;// 满多少钱
    private BigDecimal discountPrice;// 减多少钱

    public MjRules(BigDecimal achievePrice, BigDecimal discountPrice) {
        this.achievePrice = achievePrice;
        this.discountPrice = discountPrice;
    }

    public BigDecimal getAchievePrice() {
        return achievePrice;
    }

    public void setAchievePrice(BigDecimal achievePrice) {
        this.achievePrice = achievePrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }
}
