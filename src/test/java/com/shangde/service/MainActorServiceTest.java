package com.shangde.service;


import com.shangde.pojo.BaseLogInfo;
import com.shangde.queue.pojo.BeanObjClass;
import com.shangde.service.impl.SpringBeanServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.conf/*.xml"})
public class MainActorServiceTest {

    @Autowired
    MainActorService phoneActorService;

    @Test
    public void sendPhoneInfo() throws Exception {
        BaseLogInfo baseLogInfo = new BaseLogInfo("X", "Y");
        BeanObjClass objClass= new BeanObjClass("springBeanService", SpringBeanServiceImpl.class,"insert",new Class[]{BaseLogInfo.class},new Object[]{baseLogInfo});
        phoneActorService.sendMessage(objClass);
        Thread.sleep(10000);
    }
}
