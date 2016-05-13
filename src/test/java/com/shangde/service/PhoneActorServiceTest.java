package com.shangde.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shangde.queue.message.PhoneInfoMessage;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.conf/*.xml"})
public class PhoneActorServiceTest {

    @Autowired
    private PhoneActorService phoneActorService;

    @Test
    public void sendPhoneInfo() throws Exception {
        PhoneInfoMessage phoneInfoMessage = new PhoneInfoMessage();
        phoneInfoMessage.setAgentName("san");
        phoneInfoMessage.setLegionId(1);
        phoneInfoMessage.setGroupId(101);
        phoneInfoMessage.setPhoneNum("18799991111");
        phoneInfoMessage.setStudentName("小一");
        phoneActorService.sendPhoneInfo(phoneInfoMessage);

        Thread.sleep(5000);
    }
}
