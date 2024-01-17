package com.heima.schedule.service.impl;

import com.alibaba.fastjson.JSON;
import com.heima.common.constants.ScheduleConstants;
import com.heima.common.redis.CacheService;
import com.heima.model.schedule.dtos.Task;
import com.heima.schedule.ScheduleApplication;
import com.heima.schedule.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest(classes = ScheduleApplication.class)
@RunWith(SpringRunner.class)
public class TaskServiceTest {
    @Autowired
    private CacheService cacheService;
    @Autowired
    private TaskService taskService;
    @Test
    public void addTaskTest(){
        for (int i = 0; i < 10;i ++) {
            Task task = new Task();
            task.setTaskId(12306L);
            task.setTaskType(11);
            task.setPriority(12);
            task.setParameters(("addTaskTest" + i).getBytes());
            task.setExecuteTime(new Date().getTime() + 5* 60 * 1000 + (i - 5) * 1000);
            String key = task.getTaskType() + "_" + task.getPriority();
            cacheService.zAdd(ScheduleConstants.FUTURE + key, JSON.toJSONString(task), task.getExecuteTime());
        }
    }
    @Test
    public void cancelTask(){
        boolean b = taskService.cancelTask(1743974787707789313L);
        System.out.println(b);
    }
//    @Test
//    public void scheduleTest() throws InterruptedException {
//        for (int i = 0; i < 10;i ++) {
//            Task task = new Task();
//            task.setTaskId(12306L);
//            task.setTaskType(11);
//            task.setPriority(12);
//            task.setParameters(("addTaskTest" + i).getBytes());
//            task.setExecuteTime(new Date().getTime() + 5* 60 * 1000 + (i - 5) * 1000);
//            String key = task.getTaskType() + "_" + task.getPriority();
//            cacheService.zAdd(ScheduleConstants.FUTURE + key, JSON.toJSONString(task), task.getExecuteTime());
//        }
//        System.out.println("加入future队列成功，等待扫描");
//        taskService.refresh();
//    }
//    @Test
//    public void pureRefresh() {
//        taskService.refresh();
//    }
    @Test
    public void cancelKey() {
        for (int i = 1; i <= 5; i ++) {
            cacheService.delete("topic_11_12");
        }
        for (int i = 1; i <= 5; i ++) {
            cacheService.delete("future_11_12");
        }
    }
}
