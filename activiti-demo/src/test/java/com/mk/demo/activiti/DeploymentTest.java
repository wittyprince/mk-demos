package com.mk.demo.activiti;

import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.ParallelGateway;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.junit.Test;

/**
 * deployment test
 *
 * @author WangChen
 * Created on 2019/5/15 18:35
 * @since 1.0
 */
public class DeploymentTest {

    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    private RepositoryService repositoryService = processEngine.getRepositoryService();

    @Test
    public void testDeployment(){
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        deploymentBuilder.addClasspathResource("one.bpmn");
        // 部署流程定义
        Deployment deployment = deploymentBuilder.deploy();

    }

    @Test
    public void testDynamicDeployment(){
        BpmnModel bpmnModel = new BpmnModel();
        //2. Generate graphical information
        bpmnModel.addProcess(this.wrapProcess());
        new BpmnAutoLayout(bpmnModel).execute();
        //3. Deploy the process to the engine
        DeploymentBuilder deployment = repositoryService.createDeployment();
        deployment.addBpmnModel("dynamic-model.bpmn", bpmnModel)
                .name("Dynamic process deployment")
                .tenantId("0001")
                .deploy();
    }

    private Process wrapProcess(){
        org.activiti.bpmn.model.Process process = new org.activiti.bpmn.model.Process();
        process.setId("processId01");
        process.setName("processName01");

        StartEvent startEvent = new StartEvent();
        startEvent.setId("eventStart");
        process.addFlowElement(startEvent);

        ParallelGateway startParallelGateway = new ParallelGateway();
        startParallelGateway.setId("parallelGatewayStartId");
        startParallelGateway.setName("parallelGatewayStartName");
        ParallelGateway endParallelGateway = new ParallelGateway();
        endParallelGateway.setId("parallelGatewayEndId");
        endParallelGateway.setName("parallelGatewayEndName");
        process.addFlowElement(startParallelGateway);
        process.addFlowElement(endParallelGateway);

        SequenceFlow flow01 = new SequenceFlow();
        flow01.setSourceRef("eventStart");
        flow01.setTargetRef("parallelGatewayStartId");
        process.addFlowElement(flow01);

        UserTask userTask = new UserTask();
        userTask.setName("userTaskName");
        userTask.setId("userTaskId");
        userTask.setAssignee("userTaskAssignee");
        userTask.setOwner("userTaskOwner");
        userTask.setCategory("userTaskCategory");
        process.addFlowElement(userTask);

        SequenceFlow flow02 = new SequenceFlow();
        flow02.setSourceRef("parallelGatewayStartId");
        flow02.setTargetRef(userTask.getId());
        process.addFlowElement(flow02);

        SequenceFlow flow03 = new SequenceFlow();
        flow03.setSourceRef(userTask.getId());
        flow03.setTargetRef("parallelGatewayEndId");
        process.addFlowElement(flow03);

        EndEvent endEvent = new EndEvent();
        endEvent.setId("eventEnd");
        process.addFlowElement(endEvent);

        SequenceFlow flow04 = new SequenceFlow();
        flow04.setSourceRef("parallelGatewayEndId");
        flow04.setTargetRef("eventEnd");
        process.addFlowElement(flow04);
        return process;
    }
}
