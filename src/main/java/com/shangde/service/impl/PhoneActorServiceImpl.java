package com.shangde.service.impl;

import akka.actor.ActorRef;
import com.shangde.queue.factory.PortalActorRef;
import com.shangde.queue.message.PhoneInfoMessage;
import com.shangde.service.PhoneActorService;
import org.springframework.stereotype.Service;

import java.util.Queue;

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
    public Queue<PhoneInfoMessage> getPhoneInfo() {
        return null;
    }

    @Override
    public void sendPhoneInfo(PhoneInfoMessage phoneInfoMessage) {
        ActorRef defaultActorRef = PortalActorRef.getDefaultActorRef();
        defaultActorRef.tell(phoneInfoMessage, ActorRef.noSender());
    }

    @Override
    public void sendQueuePhoneInfo(Queue<PhoneInfoMessage> phoneInfoMessageQueue) {
        for (PhoneInfoMessage phoneInfoMessage : phoneInfoMessageQueue) {
            sendPhoneInfo(phoneInfoMessage);
        }
    }

}
