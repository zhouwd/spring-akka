package com.shangde.queue.actor;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import com.shangde.api.factory.StorageActorRef;
import com.shangde.queue.message.PhoneInfoMessage;
import com.shangde.queue.message.ResultInfoMessage;

import java.util.Date;

/*
 * 文件名： PhoneActor.java
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
public class PhoneActor extends UntypedActor {
    //	private static final Logger logger = LoggerFactory.getLogger(PhoneActor.class);
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof PhoneInfoMessage) {
            PhoneInfoMessage phoneInfoMessage = (PhoneInfoMessage) message;
            phoneInfoMessage.setPhoneType("Y");
            System.out.println("PhoneActor.getSelf():" + getSelf().path());
            System.out.println("PhoneActor.getSender():" + getSender().path());
            System.out.println(new Date() + ":拨打中：" + phoneInfoMessage.getPhoneNum());
            //TODO 调用CTI接口，拨打该号码
            System.out.println(new Date() + ":拨打结束：" + phoneInfoMessage.getPhoneNum());

        } else if (message instanceof ResultInfoMessage) {
            ActorRef defaultActorRef = StorageActorRef.getDefaultActorRef();
            defaultActorRef.tell(message, getSelf());
        } else {
            unhandled(message);
        }

    }

}
