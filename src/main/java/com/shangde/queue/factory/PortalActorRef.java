package com.shangde.queue.factory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.shangde.queue.actor.LegionActor;
import com.shangde.queue.message.PhoneInfoMessage;
import com.typesafe.config.ConfigFactory;

import java.util.HashMap;
import java.util.Map;

/*
 * 文件名： ActorFactory.java
 * 
 * 工程名称: spring-akka
 *
 * 创建消息的入口。
 *
 * 创建日期： 2016年04月21日
 *
 * Copyright(C) 2015, by Shangde
 *
 * 原始作者: zhouwendong
 *
 */
public class PortalActorRef {

    private static ActorRef portalActorRef;

    private PortalActorRef() {

    }

    public static ActorRef getDefaultActorRef() {
        if (portalActorRef == null) {
            ActorSystem system = ActorSystem.create("ServerApp", ConfigFactory.load("akka.conf/server").getConfig("ServerSocketApp"));
            portalActorRef = system.actorOf(Props.create(PortalActor.class), "mainActor");
        }
        return portalActorRef;
    }


}

class PortalActor extends UntypedActor {

    private Map<String, ActorRef> actorRefMap = new HashMap<>();

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof PhoneInfoMessage) {
            PhoneInfoMessage phoneInfoMessage = (PhoneInfoMessage) message;
            if (phoneInfoMessage.getPhoneNum() == null) {
                return;
            }
            Props props = Props.create(LegionActor.class);
            String actorName = "legion_" + phoneInfoMessage.getLegionId().toString();
            ActorRef actorRef = actorRefMap.get(actorName);
            if (actorRef == null) {
                actorRef = getContext().actorOf(props, actorName);
                actorRefMap.put(actorName, actorRef);
            }

            actorRef.tell(phoneInfoMessage, getSelf());

        } else {
            unhandled(message);
        }
    }

}