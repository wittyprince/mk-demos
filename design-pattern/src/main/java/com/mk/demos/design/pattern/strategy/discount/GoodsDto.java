package com.mk.demos.design.pattern.strategy.discount;

import java.math.BigDecimal;

/**
 * 商品DTO
 *
 * @author WangChen
 * Created on 2021/1/23 19:04
 * @since 1.0
 */
public class GoodsDto {

    private String name; // 商品名称
    private String code; // 商品编码
    private BigDecimal price; // 商品价格

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
