package com.mk.demos.mapstruct.complex.decoretor;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.mk.demos.mapstruct.complex.expression.TaskDO;
import com.mk.demos.mapstruct.complex.expression.TaskVO;

/**
 * OneMapper
 *
 * @author WangChen
 * Created on 2021/8/4 16:14
 * @since 0.1
 */

@Mapper
@DecoratedWith(DecorateMapperDecorator.class)
public interface DecorateMapper {

    DecorateMapper INSTANCE = Mappers.getMapper(DecorateMapper.class);

    TaskVO toTaskVo(TaskDO taskDO);
}
