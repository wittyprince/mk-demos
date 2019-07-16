package com.mk.demo.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.junit.Test;

/**
 * mode test
 *
 * @author WangChen
 * Created on 2019/5/15 17:16
 * @since 1.0
 */
public class ModelTest {

    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    private RepositoryService repositoryService;

    @Test
    public void testSave(){
        repositoryService = processEngine.getRepositoryService();
        Model model = repositoryService.newModel();
        System.out.println("modelId: " + model.getId());
        model.setCategory("ccc");
        model.setKey("kkk");
        model.setMetaInfo("{\"id\":1001}");
        model.setName("m");
        model.setTenantId("0001");
        repositoryService.saveModel(model);
    }
}
