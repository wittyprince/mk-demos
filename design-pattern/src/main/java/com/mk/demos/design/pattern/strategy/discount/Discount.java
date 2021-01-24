package com.mk.demos.design.pattern.strategy.discount;

/**
 * 商品折扣
 *
 * @author WangChen
 * Created on 2021/1/23 18:55
 * @since 1.0
 */
public interface Discount {

    void discount(GoodsDto goodsDto);
}
