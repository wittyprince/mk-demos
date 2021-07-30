package com.mk.demos.mapstruct.complex.expression;

/**
 * task
 *
 * @author WangChen
 * Created on 2021/7/30 13:24
 * @since 0.1
 */
public class TaskDO {

    private Integer taskStatus;

    public TaskDO(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }
}
