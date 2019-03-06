package com.mk.demo.activiti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

/**
 * 流程变量
 * 流程变量的声明周期和当前流程实例的声明周期一致，
 * 如果当前流程实例执行完毕，流程变量消失
 * Created by WangChen on 2019/3/5 15:25.
 */
public class VariableTest {

    ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
    /**
     * 设置流程变量方式一：在启动流程实例时设置
     */
    @Test
    public void test2() {
        String processDefinitionKey = "variable";
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("key1", "value1");
        variables.put("key2", 200);
        ProcessInstance pi = pe.getRuntimeService().startProcessInstanceByKey(processDefinitionKey, variables);
        System.out.println(pi.getId());
    }

    /**
     * 设置流程变量方式二：在办理任务时设置
     */
    @Test
    public void test3() {
        String taskId = "1206";
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("user", new User(1,"小王"));
        pe.getTaskService().complete(taskId, variables);


		/*Task task = pe.getTaskService().createTaskQuery().taskId(taskId).singleResult();
		String processInstanceId = task.getProcessInstanceId();
		System.out.println(processInstanceId);*/
    }

    /**
     * 设置流程变量方式三：使用RuntimeService的方法设置
     */
    @Test
    public void test4() {
        String executionId = "601";//流程实例id
        String variableName = "key3";
        Object value = "value3";
        pe.getRuntimeService().setVariable(executionId , variableName , value);
    }

    /**
     * 设置流程变量方式四：使用TaskService的方法设置
     */
    @Test
    public void test5() {
        String taskId = "704";
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("key4", 400);
        variables.put("k5", "v5");
        pe.getTaskService().setVariables(taskId , variables);
    }

    /**
     * 获取流程变量方式一：使用RuntimeService的方法获取
     */
    @Test
    public void test6(){
        String executionId = "1201";
        Map<String, Object> variables = pe.getRuntimeService().getVariables(executionId);
        //System.out.println(variables);
        Set<String> set = variables.keySet();//key2 key1 user
        for (String key : set) {
            Object value = variables.get(key);
            //System.out.println(key + " = " + value);
        }

        Object value = pe.getRuntimeService().getVariable(executionId, "user");
        //System.out.println(value);

        Collection<String> variableNames = new ArrayList<String>();
        variableNames.add("key2");
        variableNames.add("user");
        Map<String, Object> map = pe.getRuntimeService().getVariables(executionId, variableNames);
        System.out.println(map);
    }

    /**
     * 获取流程变量方式二：使用TaskService的方法获取
     */
    @Test
    public void test7(){
        String taskId = "1305";
        Map<String, Object> variables = pe.getTaskService().getVariables(taskId );
        System.out.println(variables);
    }

    private class User implements Serializable{
        private int id;
        private String name;

        public User() {}
        public User(int id, String username) {
        }
    }
}
