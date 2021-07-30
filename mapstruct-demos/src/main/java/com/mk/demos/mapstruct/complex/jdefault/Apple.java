package com.mk.demos.mapstruct.complex.jdefault;

/**
 * apple
 *
 * @author WangChen
 * Created on 2021/7/30 14:01
 * @since 0.1
 */
public class Apple {

    private Double price;
    private Double discount;

    public Apple() {
    }

    public Apple(Double price, Double discount) {
        this.price = price;
        this.discount = discount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

}
