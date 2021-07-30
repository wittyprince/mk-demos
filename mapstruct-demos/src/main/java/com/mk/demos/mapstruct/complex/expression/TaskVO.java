package com.mk.demos.mapstruct.complex.expression;

/**
 * task VO
 *
 * @author WangChen
 * Created on 2021/7/30 13:25
 * @since 0.1
 */
public class TaskVO {

    private Integer taskStatus;
    private String taskStatusName;

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskStatusName() {
        return taskStatusName;
    }

    public void setTaskStatusName(String taskStatusName) {
        this.taskStatusName = taskStatusName;
    }

    @Override
    public String toString() {
        return "TaskVO{" +
                "taskStatus=" + taskStatus +
                ", taskStatusName='" + taskStatusName + '\'' +
                '}';
    }
}
