package com.mk.demos.mapstruct.custom;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * 自定义mapper
 *
 * @author WangChen
 * Created on 2021/7/30 11:07
 * @since 0.1
 */
@Mapper(uses = {DateToStringMapper.class, LocalDateTimeMapper.class})
public interface CustomMapper {

    CustomMapper INSTANCE = Mappers.getMapper(CustomMapper.class);

    StudentDto toDto(Student student);

    @Mapping(target = "graduationTime", expression = "java(localDateTimeMapper.localDateTimeToLong(student.getGraduationTime(), zoneId))")
    StudentDto toDto(Student student, @Context String zoneId);

}
