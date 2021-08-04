package com.mk.demos.mapstruct.complex.decoretor;

import com.mk.demos.mapstruct.complex.expression.TaskDO;
import com.mk.demos.mapstruct.complex.expression.TaskStatusEnum;
import com.mk.demos.mapstruct.complex.expression.TaskVO;

/**
 * OneMapper 装饰器类
 *
 * @author WangChen
 * Created on 2021/8/4 16:13
 * @since 0.1
 */
public abstract class DecorateMapperDecorator implements DecorateMapper {

    private final DecorateMapper delegate;
    protected DecorateMapperDecorator(DecorateMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public TaskVO toTaskVo(TaskDO taskDO) {
        TaskVO taskVO = delegate.toTaskVo(taskDO);
        taskVO.setTaskStatusName(TaskStatusEnum.getNameByCode(taskDO.getTaskStatus()));
        return taskVO;
    }

}
