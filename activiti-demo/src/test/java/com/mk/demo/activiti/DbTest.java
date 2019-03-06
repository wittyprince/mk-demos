package com.mk.demo.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * database initial
 * Created by WangChen on 2019/3/1 10:46.
 */
public class DbTest {

    /**
     * 使用框架提供的自动建表(不提供配置文件)
     */
    @Test
    public void test1(){
        // 创建流程引擎配置对象
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        // 设置数据源信息
        configuration.setJdbcDriver("com.mysql.jdbc.Driver");
        configuration.setJdbcUrl("jdbc:mysql://192.168.52.134/activiti01?useUnicode=true&useSSL=true");
        configuration.setJdbcUsername("wangchen");
        configuration.setJdbcPassword("wangchen@123");
        // 设置自动创建表
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 创建一个流程引擎对象，在创建的过程中，会自动建表
        ProcessEngine processEngine = configuration.buildProcessEngine();
    }

    /**
     * 使用框架提供的自动建表(提供配置文件)
     */
    @Test
    public void test2(){
        String resource = "activiti-context.xml";//配置文件名称
        String beanName = "processEngineConfiguration";//bean id
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource(resource, beanName);
        ProcessEngine processEngine = configuration.buildProcessEngine();
    }

    /**
     * 使用框架提供的自动建表(提供配置文件)
     * 要求配置文件名称必须为activiti-context.xml或者activiti.cfg.xml,配置的信息必须为
     * 且配置文件中必须有bean id 为 processEngineConfiguration的ProcessEngineConfiguration
     * 和bean id为processEngine的ProcessEngine
     */
    @Test
    public void test3(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    }
}
