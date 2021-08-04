package com.mk.demos.mapstruct.complex.expression;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * DO:{ taskStatus} -> VO:{ taskStatus, taskStatusName}
 *
 * @author WangChen
 * Created on 2021/7/30 13:22
 * @since 0.1
 */
@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(target = "taskStatusName", expression = "java(TaskStatusEnum.getNameByCode(taskDO.getTaskStatus()))")
    TaskVO toTaskVo(TaskDO taskDO);

    default void m(){
        String nameByCode = TaskStatusEnum.getNameByCode(1);
    }

}
