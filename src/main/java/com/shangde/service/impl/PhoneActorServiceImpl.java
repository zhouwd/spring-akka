package com.shangde.service.impl;

import java.util.Queue;

import akka.actor.ActorRef;
import com.shangde.pojo.PhoneInfo;
import com.shangde.queue.factory.PortalActorRef;
import com.shangde.service.PhoneActorService;
import org.springframework.stereotype.Service;

/*
 * 文件名： DemoServiceImpl.java
 * 
 * 工程名称: spring-akka
 *
 * Shang De
 *
 * 创建日期： 2016年04月21日
 *
 * Copyright(C) 2015, by Shangde
 *
 * 原始作者: zhouwendong
 *
 */
@Service(value = "phoneActorService")
public class PhoneActorServiceImpl implements PhoneActorService {


    @Override
    public Queue<PhoneInfo> getPhoneInfo() {
        return null;
    }

    @Override
    public void sendPhoneInfo(PhoneInfo phoneInfo) {
        ActorRef defaultActorRef = PortalActorRef.getDefaultActorRef();
        defaultActorRef.tell(phoneInfo, ActorRef.noSender());
    }

    @Override
    public void sendQueuePhoneInfo(Queue<PhoneInfo> phoneInfoQueue) {
        for (PhoneInfo phoneInfo : phoneInfoQueue) {
            sendPhoneInfo(phoneInfo);
        }
    }

}
