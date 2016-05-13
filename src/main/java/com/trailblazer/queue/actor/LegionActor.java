package com.trailblazer.queue.actor;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.trailblazer.queue.message.EventMessages;
import com.trailblazer.queue.message.PhoneInfoMessage;

import java.util.HashMap;
import java.util.Map;

/*
 * 文件名： GroupActor.java
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
public class LegionActor extends UntypedActor {

    private Map<String, ActorRef> actorRefMap = new HashMap<>();

    @Override
    public void onReceive(Object message) throws Exception {
//		System.out.println(getSelf().path() + " message=" + message.toString());
        if (message instanceof PhoneInfoMessage) {
            PhoneInfoMessage phoneInfoMessage = (PhoneInfoMessage) message;
            Props props = Props.create(GroupActor.class);

            String actorName = "group_" + phoneInfoMessage.getGroupId();

            ActorRef actorRef = actorRefMap.get(actorName);
            if (actorRef == null) {
                actorRef = getContext().actorOf(props, actorName);
                actorRefMap.put(actorName, actorRef);
            }
            phoneInfoMessage.setMsg("it is in legionActor:" + getSelf());
            actorRef.tell(phoneInfoMessage, getSelf());

        } else if (message instanceof String && "EOF".equals(message.toString())) {
            System.out.println("关闭该队列");
            getContext().system().shutdown();

        } else if (message instanceof EventMessages.ClearCache) {
            EventMessages.ClearCache clearCache = (EventMessages.ClearCache) message;
            String actorName = "group_" + clearCache.getGroupId();
            ActorRef actorRef = actorRefMap.get(actorName);

        } else {
            unhandled(message);
        }
    }


}
