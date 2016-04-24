package com.shangde.service;


import com.shangde.pojo.PhoneInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.conf/*.xml"})
public class PhoneActorServiceTest {

    @Autowired
    PhoneActorService phoneActorService;

    @Test
    public void sendPhoneInfo() throws Exception {
        PhoneInfo phoneInfo = new PhoneInfo();
        phoneInfo.setAgentName("san");
        phoneInfo.setLegionId(1);
        phoneInfo.setGroupId(101);
        phoneInfo.setPhoneNum("18799991111");
        phoneInfo.setStudentName("小一");
        phoneActorService.sendPhoneInfo(phoneInfo);
    }
}
