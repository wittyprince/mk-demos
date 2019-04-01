package com.mk.demo.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

/**
 * @author WangChen
 * Created on 2019/4/1 17:08
 * @since
 */
public class TaskServiceTest {

    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    private TaskService taskService = processEngine.getTaskService();

    @Test
    public void testTaskQuery(){
        String processInstanceId = "5001";
        List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstanceId).list();
        for (Task task : tasks){
            System.out.println("taskId:" + task.getId());
        }
    }
}
