package com.mk.demo.activiti;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * 流程process test
 * Created by WangChen on 2019/3/4 23:54.
 */
public class ProcessTest {

    /**
     * 部署流程定义
     * (操作数据表: act_re_deployment, act_re_procdef, act_ge_bytearray)
     *      insert ResourceEntity[id=10002, name=t1.bpmn]
     *      insert ResourceEntity[id=10003, name=t1.myProcess_1.png]
     *      insert ProcessDefinitionEntity[myProcess_1:4:10004]
     *      insert DeploymentEntity[id=10001, name=null]
     * ------------------------------------------------------------
     *      insert ACT_RE_DEPLOYMENT    部署信息表
     *      insert ACT_RE_PROCDEF       流程定义数据表
     *      insert ACT_GE_BYTEARRAY     二进制数据表
     * ------------------------------------------------------------
     * 注意可以把ACT_RE_PROCDEF认为是ACT_RE_DEPLOYMENT的扩展表
     *
     * 方式一：读取单个的流程定义文件(.bpmn)
     * 方式二：读取zip压缩文件
     */
    @Test
    public void test1() throws JsonProcessingException {
        // 获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 获取一个流程构建器对象，用于加载流程定义文件(t1.bpmn, t1.png)完成流程定义的部署
        DeploymentBuilder deploymentBuilder = processEngine.getRepositoryService().createDeployment();
        // 加载流程定义文件
        deploymentBuilder.addClasspathResource("t2.bpmn");
        // 部署流程定义
        Deployment deployment = deploymentBuilder.deploy();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(deployment);
        System.out.println(json);

        // 方式二：读取zip压缩文件
//        ZipInputStream zipInputStream = new ZipInputStream(this.getClass()
//                .getClassLoader().getResourceAsStream("process.zip"));
//        deploymentBuilder.addZipInputStream(zipInputStream);
//        deploymentBuilder.name("请假流程部署");
//        Deployment deployment = deploymentBuilder.deploy();
    }

    /**
     * 查询部署列表
     *      ACT_RE_DEPLOYMENT
     */
    @Test
    public void test11() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 部署查询对象，查询表act_re_deployment
        DeploymentQuery query = processEngine.getRepositoryService()
                .createDeploymentQuery();
        query.deploymentKeyLike("my");
        List<Deployment> list = query.list();
        for (Deployment deployment : list) {
            String id = deployment.getId();
            System.out.println(id);
        }
    }

    /**
     * 查询流程定义
     * 操作数据表：ACT_RE_PROCDEF
     */
    @Test
    public void test2(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 流程查询对象, 用于查询表act_re_procdef
        ProcessDefinitionQuery query = processEngine.getRepositoryService().createProcessDefinitionQuery();
        // 添加过滤条件
        query.deploymentId("7501");
        // 添加排序
        query.orderByProcessDefinitionVersion().desc();
        // 添加分页
        query.listPage(0, 10);
        List<ProcessDefinition> list = query.list();
        System.out.println(list);
    }

    /**
     * 删除部署信息
     */
    @Test
    public void test21() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        String deploymentId = "1001";
        // processEngine.getRepositoryService().deleteDeployment(deploymentId);
        processEngine.getRepositoryService().deleteDeployment(deploymentId, true);
    }

    /**
     * 删除流程定义(通过删除部署信息达到删除流程定义的目的)
     */
    @Test
    public void test22() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        String deploymentId = "1401";
        // processEngine.getRepositoryService().deleteDeployment(deploymentId);
        processEngine.getRepositoryService().deleteDeployment(deploymentId, true);
    }

    /**
     * 查询一次部署对应的流程定义文件名称和对应的输入流（bpmn png）
     *
     * @throws Exception
     */
    @Test
    public void test23() throws Exception {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        String deploymentId = "101";
        List<String> names = processEngine.getRepositoryService().getDeploymentResourceNames(deploymentId);
        for (String name : names) {
            System.out.println(name);
            InputStream in = processEngine.getRepositoryService().getResourceAsStream(deploymentId, name);
            // 将文件保存到本地磁盘
            /*
             * OutputStream out = new FileOutputStream(new File("d:\\" + name));
             * byte[] b = new byte[1024]; int len = 0; while((len =
             * in.read(b))!=-1) { out.write(b, 0, len); } out.close();
             */
//            FileUtils.copyInputStreamToFile(in, new File("d:\\" + name));
            in.close();
        }
    }

    /**
     * 获得png文件的输入流
     *
     * @throws Exception
     */
    @Test
    public void test24() throws Exception {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        String processDefinitionId = "qjlc:9:1204";
        InputStream pngInputStream = processEngine.getRepositoryService().getProcessDiagram(processDefinitionId);
//        FileUtils.copyInputStreamToFile(pngInputStream, new File("d:\\my.png"));
    }

    /**
     * 启动流程实例
     * 根据流程定义的id启动一个流程实例
     * 操作数据表：
     *    insert ProcessInstance[7501]
     *    insert Execution[ id '7502' ] - activity '_3 - parent '7501'
     *    insert org.activiti.engine.impl.persistence.entity.HistoricTaskInstanceEntityImpl@3fa2213
     *    insert Task[id=7505, name=UserTask]
     *    insert HistoricActivityInstanceEntity[id=7503, activityId=_2, activityName=StartEvent]
     *    insert HistoricActivityInstanceEntity[id=7504, activityId=_3, activityName=UserTask]
     *    insert HistoricProcessInstanceEntity[superProcessInstanceId=null]
     *    ----------------------------------------------
     *    insert ACT_HI_TASKINST
     *    insert ACT_HI_PROCINST
     *    insert ACT_HI_ACTINST
     *    insert ACT_RU_EXECUTION
     *    insert ACT_RU_TASK
     *    --------------------------------------------------------------
     *    方式一：根据流程定义的id启动
     *    方式二：根据流程定义的key启动(自动选择最新版本的流程定义启动流程实例)
     *    --------------------------------------------------------------
     *    注意：activiti框架提供的对象和表对应的关系
     *    Deployment        --- act_re_deployment
     *    ProcessDefinition --- act_re_procdef
     *    ProcessInstance   --- act_ru_execution
     *    Task              --- act_ru_task
     *
     */
    @Test
    public void test3(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        String processDefinitionId = "myProcess_1:6:30004";
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinitionId);
        System.out.println(processInstance);

        // 方式二
//        String processDefinitionKey = "qjlc";
//        ProcessInstance processInstance = processEngine.getRuntimeService()
//                .startProcessInstanceByKey(processDefinitionKey);
//        System.out.println(processInstance.getId());
    }

    /**
     * 查询流程实例列表,查询act_ru_execution表
     ----------------------------------------------------
     SELECT DISTINCT
         RES.*,
         P.KEY_           AS ProcessDefinitionKey,
         P.ID_            AS ProcessDefinitionId,
         P.NAME_          AS ProcessDefinitionName,
         P.VERSION_       AS ProcessDefinitionVersion,
         P.DEPLOYMENT_ID_ AS DeploymentId
     FROM ACT_RU_EXECUTION RES INNER JOIN ACT_RE_PROCDEF P ON RES.PROC_DEF_ID_ = P.ID_
     WHERE RES.PARENT_ID_ IS NULL AND P.KEY_ = ?
     ORDER BY RES.ID_ DESC
     LIMIT ? OFFSET ?
     ----------------------------------------------------
     */
    @Test
    public void test31(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //流程实例查询对象，查询act_ru_execution表
        ProcessInstanceQuery query = processEngine.getRuntimeService().createProcessInstanceQuery();
        query.processDefinitionKey("myProcess_1");
        query.orderByProcessInstanceId().desc();
        query.listPage(0, 10);
        List<ProcessInstance> list = query.list();
        for (ProcessInstance pi : list) {
            System.out.println(pi.getId() + " " + pi.getActivityId());
        }
    }

    /**
     * 结束流程实例,操作的表act_ru_execution act_ru_task
     */
    @Test
    public void test32(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        String processInstanceId = "1601";
        processEngine.getRuntimeService().deleteProcessInstance(processInstanceId , "我愿意");
    }

    /**
     * 查询个人任务列表 starting TaskQueryImpl
     * ACT_RU_TASK
     ----------------------------------------------------
     SELECT DISTINCT RES.*
     FROM ACT_RU_TASK RES
     WHERE RES.ASSIGNEE_ = 'zhangsan'
     ORDER BY RES.ID_ ASC
     LIMIT ? OFFSET ?;
     ----------------------------------------------------
     */
    @Test
    public void test4(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery();
        String taskAssignee = "zhangsan";
        taskQuery.taskAssignee(taskAssignee);
        List<Task> list = taskQuery.list();
        System.out.println(list);
    }

    /**
     * 办理个人任务
     *      insert org.activiti.engine.impl.persistence.entity.HistoricTaskInstanceEntityImpl@4a891c97
     *      insert IdentityLinkEntity[id=37503, type=participant, userId=lisi, processInstanceId=10001]
     *      insert HistoricActivityInstanceEntity[id=37501, activityId=_5, activityName=经理审批]
     *      insert Task[id=37502, name=经理审批]
     *      insert org.activiti.engine.impl.persistence.entity.HistoricIdentityLinkEntityImpl@a5bd950
     *      update org.activiti.engine.impl.persistence.entity.HistoricTaskInstanceEntityImpl@4d18aa28
     *      update Execution[ id '10002' ] - activity '_5 - parent '10001'
     *      update HistoricActivityInstanceEntity[id=10004, activityId=_3, activityName=qjsc]
     *      delete Task[id=10005, name=qjsc] with id 10005
     * -------------------------------------------------------------
     *      insert into ACT_HI_TASKINST
     *      insert into ACT_HI_ACTINST
     *      insert into ACT_HI_IDENTITYLINK
     *      insert into ACT_RU_TASK
     *      insert into ACT_RU_IDENTITYLINK
     *      update ACT_HI_TASKINST
     *      update ACT_RU_EXECUTION
     *      update ACT_HI_ACTINST
     *      delete from ACT_RU_TASK
     * -------------------------------------------------------------
     * complete all tasks of a process:
     *      insert HistoricActivityInstanceEntity[id=42501, activityId=_9, activityName=end]
     *      update org.activiti.engine.impl.persistence.entity.HistoricTaskInstanceEntityImpl@476b0ae6
     *      update Execution[ id '10002' ] - activity '_9 - parent '10001'
     *      update ProcessInstance[10001]
     *      update HistoricActivityInstanceEntity[id=40001, activityId=_6, activityName=总监审批]
     *      update HistoricProcessInstanceEntity[superProcessInstanceId=null]
     *      delete Execution[ id '10002' ] - activity '_9 - parent '10001' with id 10002
     *      delete ProcessInstance[10001] with id 10001
     *      delete Task[id=40002, name=总监审批] with id 40002
     *      delete IdentityLinkEntity[id=37503, type=participant, userId=lisi, processInstanceId=10001] with id 37503
     *      delete IdentityLinkEntity[id=40003, type=participant, userId=wangwu, processInstanceId=10001] with id 40003
     *      delete IdentityLinkEntity[id=10006, type=participant, userId=zhangsan, processInstanceId=10001] with id 10006
     */
    @Test
    public void test5(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        String taskId = "40002";//"37502";//"10005";
        taskService.complete(taskId);
    }

    /**
     * 直接将流程向下执行一步
     */
    @Test
    public void test13(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        String executionId = "2701";//流程实例id
//        processEngine.getRuntimeService().signal(executionId);
    }

}
