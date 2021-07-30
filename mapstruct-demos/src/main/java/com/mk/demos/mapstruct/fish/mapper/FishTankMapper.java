package com.mk.demos.mapstruct.fish.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.mk.demos.mapstruct.fish.dto.FishTankDto;
import com.mk.demos.mapstruct.fish.model.FishTank;

/**
 * FishTankMapper
 *
 * @author WangChen
 * Created on 2021/7/30 10:17
 * @since 0.1
 */
@Mapper
public interface FishTankMapper {

    FishTankMapper INSTANCE = Mappers.getMapper( FishTankMapper.class );

    @Mapping(target = "fish.kind", source = "fish.type")
    @Mapping(target = "fish.name", ignore = true)
    @Mapping(target = "ornament", source = "interior.ornament")
    @Mapping(target = "material.materialType", source = "material")
    @Mapping(target = "quality.report.organisation.name", source = "quality.report.organisationName")
    FishTankDto map(FishTank source);

    @Mapping(target = "fish.kind", source = "source.fish.type")
    @Mapping(target = "fish.name", ignore = true)
    @Mapping(target = "ornament", source = "source.interior.ornament")
    @Mapping(target = "material.materialType", source = "source.material")
    @Mapping(target = "quality.report.organisation.name", source = "source.quality.report.organisationName")
    FishTankDto mapAsWell(FishTank source);

    @InheritInverseConfiguration( name = "map" )
    FishTank map(FishTankDto source);

}
