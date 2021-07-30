package com.mk.demos.mapstruct.fish.dto;

/**
 * MaterialDto
 *
 * @author WangChen
 * Created on 2021/7/30 10:24
 * @since 0.1
 */
public class MaterialDto {
    private String manufacturer;
    private MaterialTypeDto materialType;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public MaterialTypeDto getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialTypeDto materialType) {
        this.materialType = materialType;
    }
}
