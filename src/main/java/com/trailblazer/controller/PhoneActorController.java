package com.trailblazer.controller;

import com.trailblazer.queue.message.PhoneInfoMessage;
import com.trailblazer.service.PhoneActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/phoneActor")
public class PhoneActorController {


    @Autowired
    private PhoneActorService phoneActorService;

    @RequestMapping("/runActor")
    @ResponseBody
    public String runActor() {
        PhoneInfoMessage phoneInfoMessage = new PhoneInfoMessage();
        phoneInfoMessage.setAgentName("san");
        phoneInfoMessage.setLegionId(1);
        phoneInfoMessage.setGroupId(101);
        phoneInfoMessage.setPhoneNum("18799991111");
        phoneInfoMessage.setStudentName("小一");
        phoneActorService.sendPhoneInfo(phoneInfoMessage);

        PhoneInfoMessage p2 = new PhoneInfoMessage();
        p2.setAgentName("san2");
        p2.setLegionId(1);
        p2.setGroupId(101);
        p2.setPhoneNum("18799992222");
        p2.setStudentName("小二");
        phoneActorService.sendPhoneInfo(p2);

        PhoneInfoMessage p3 = new PhoneInfoMessage();
        p3.setAgentName("san3");
        p3.setLegionId(2);
        p3.setGroupId(203);
        p3.setPhoneNum("18799993333");
        p3.setStudentName("小三");
        phoneActorService.sendPhoneInfo(p3);
        return "";
    }

}
