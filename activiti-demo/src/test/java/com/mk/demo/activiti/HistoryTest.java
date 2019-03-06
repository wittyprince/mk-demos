package com.mk.demo.activiti;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.junit.Test;

/**
 * 历史数据查询
 * Created by WangChen on 2019/3/5 15:10.
 */
public class HistoryTest {

    ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
    /**
     * 查询历史流程实例列表
     * ACT_HI_PROCINST RES left outer join ACT_RE_PROCDEF DEF on RES.PROC_DEF_ID_ = DEF.ID_
     */
    @org.junit.Test
    public void test5() {
        HistoricProcessInstanceQuery query = pe.getHistoryService().createHistoricProcessInstanceQuery();
        List<HistoricProcessInstance> list = query.list();
        for (HistoricProcessInstance hi : list) {
            System.out.println(hi.getId());
        }
    }

    /**
     * 查询历史活动数据列表
     * ACT_HI_ACTINST
     */
    @org.junit.Test
    public void test6() {
        HistoricActivityInstanceQuery query = pe.getHistoryService().createHistoricActivityInstanceQuery();
        // 按照流程实例排序
        query.orderByProcessInstanceId().desc();
        query.orderByHistoricActivityInstanceEndTime().asc();
        List<HistoricActivityInstance> list = query.list();
        for (HistoricActivityInstance hi : list) {
            System.out.println(hi.getActivityId() + " " + hi.getActivityName() + " " + hi.getActivityType());
        }
    }

    /**
     * 查询历史任务数据列表
     * ACT_HI_TASKINST
     */
    @Test
    public void test7() {
        HistoricTaskInstanceQuery query = pe.getHistoryService().createHistoricTaskInstanceQuery();
        query.orderByProcessInstanceId().asc();
        query.orderByHistoricTaskInstanceEndTime().desc();
        List<HistoricTaskInstance> list = query.list();
        for (HistoricTaskInstance hi : list) {
            System.out.println(hi.getAssignee() + " " + hi.getName() + " " + hi.getStartTime());
        }
    }
}
