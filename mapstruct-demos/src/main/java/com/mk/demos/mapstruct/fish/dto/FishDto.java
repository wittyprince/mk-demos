package com.mk.demos.mapstruct.fish.dto;

/**
 * FishDto
 *
 * @author WangChen
 * Created on 2021/7/30 10:19
 * @since 0.1
 */
public class FishDto {

    private String kind;

    // make sure that mapping on name does not happen based on name mapping
    private String name;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
