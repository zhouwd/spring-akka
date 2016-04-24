package com.shangde.controller;

import com.shangde.pojo.PhoneInfo;
import com.shangde.service.PhoneActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/phoneActor")
public class PhoneActorController {


    @Autowired
    private PhoneActorService phoneActorService;

    @RequestMapping("/runActor")
    public void runActor() {
        PhoneInfo phoneInfo = new PhoneInfo();
        phoneInfo.setAgentName("san");
        phoneInfo.setLegionId(1);
        phoneInfo.setGroupId(101);
        phoneInfo.setPhoneNum("18799991111");
        phoneInfo.setStudentName("小一");
        phoneActorService.sendPhoneInfo(phoneInfo);

        PhoneInfo p2 = new PhoneInfo();
        p2.setAgentName("san2");
        p2.setLegionId(1);
        p2.setGroupId(101);
        p2.setPhoneNum("18799992222");
        p2.setStudentName("小二");
        phoneActorService.sendPhoneInfo(p2);

        PhoneInfo p3 = new PhoneInfo();
        p3.setAgentName("san3");
        p3.setLegionId(2);
        p3.setGroupId(203);
        p3.setPhoneNum("18799993333");
        p3.setStudentName("小三");
        phoneActorService.sendPhoneInfo(p3);
    }

}
