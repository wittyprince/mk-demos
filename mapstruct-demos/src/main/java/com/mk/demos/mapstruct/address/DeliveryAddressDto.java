package com.mk.demos.mapstruct.address;

/**
 * @author WangChen
 * Created on 2021/7/29 15:55
 * @since
 */
public class DeliveryAddressDto {

    private String description;
    private String houseNumber;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
