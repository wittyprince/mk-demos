package com.mk.demos.mapstruct.custom;

import org.mapstruct.Mapper;

/**
 * 自定义mapper
 *
 * @author WangChen
 * Created on 2021/7/30 11:07
 * @since 0.1
 */
@Mapper(uses = {DateToStringMapper.class, LocalDateTimeMapper.class})
public interface CustomMapper {

    StudentDto toDto(Student student);
}
