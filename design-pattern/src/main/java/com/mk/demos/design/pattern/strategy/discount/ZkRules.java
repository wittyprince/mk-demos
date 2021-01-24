package com.mk.demos.design.pattern.strategy.discount;

import java.math.BigDecimal;

/**
 * 折扣活动规则
 *
 * @author WangChen
 * Created on 2021/1/23 19:31
 * @since 1.0
 */
public class ZkRules {

    private BigDecimal achievePrice;// 满多少钱
    private BigDecimal discount;// 打几折

    public ZkRules(BigDecimal achievePrice, BigDecimal discount) {
        this.achievePrice = achievePrice;
        this.discount = discount;
    }

    public BigDecimal getAchievePrice() {
        return achievePrice;
    }

    public void setAchievePrice(BigDecimal achievePrice) {
        this.achievePrice = achievePrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
