package com.mk.demos.mapstruct.complex.jdefault;

/**
 * apple VO
 *
 * @author WangChen
 * Created on 2021/7/30 14:02
 * @since 0.1
 */
public class AppleVO {

    private Double price;
    private Double discount;
    private Double discountPrice;

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

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "AppleVO{" +
                "price=" + price +
                ", discount=" + discount +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
