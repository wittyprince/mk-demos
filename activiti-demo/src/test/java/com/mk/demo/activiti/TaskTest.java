package com.mk.demo.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

/**
 * 任务
 * Created by WangChen on 2019/3/5 15:39.
 */
public class TaskTest {

    ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
    /**
     * 查询公共任务列表
     */
    @Test
    public void test4(){
        TaskQuery query = pe.getTaskService().createTaskQuery();
        String candidateUser = "李四";
        //根据候选人过滤
        query.taskCandidateUser(candidateUser);
        List<Task> list = query.list();
        for (Task task : list) {
            System.out.println(task.getName());
        }
    }

    /**
     * 拾取任务（将公共任务变为个人任务）
     */
    @Test
    public void test5(){
        String taskId = "1602";
        String userId = "王五";
        pe.getTaskService().claim(taskId , userId);
    }

    /**
     * 退回任务（将个人任务变为公共任务）
     */
    @Test
    public void test6(){
        String taskId = "1602";
        pe.getTaskService().setAssignee(taskId , null);
    }

    /**
     * 处理接收任务
     * 接收任务不是由某个人负责办理，通过signal方法让流程执行的
     */
    @Test
    public void test7(){
        String executionId = "2101";
//        pe.getRuntimeService().signal(executionId );
    }
}
