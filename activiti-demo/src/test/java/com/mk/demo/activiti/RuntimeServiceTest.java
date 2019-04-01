package com.mk.demo.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

/**
 * @author WangChen
 * Created on 2019/4/1 16:06
 * @since
 */
public class RuntimeServiceTest {

    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    private RuntimeService runtimeService = processEngine.getRuntimeService();

    @Test
    public void testStartProcessInstance(){
//        String tenantId = "0001";
//        String processDefinitionKey = "";
//        runtimeService.startProcessInstanceByKeyAndTenantId(processDefinitionKey, tenantId);
        String processDefinitionId = "processId01:2:2504";
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinitionId);
        System.out.println(processInstance.getId());
    }
}
