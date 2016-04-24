package com.shangde.queue.actor;

import java.util.ArrayDeque;
import java.util.Queue;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.shangde.pojo.PhoneInfo;
import com.shangde.queue.message.PhoneMessage;
import com.shangde.util.CommonUtil;

/*
 * 文件名： PhoneBookActor.java
 * 
 * 工程名称: spring-akka
 *
 * Shang De
 *
 * 创建日期： 2016年04月22日
 *
 * Copyright(C) 2015, by Shangde
 *
 * 原始作者: zhouwendong
 *
 */
public class AgentActor extends UntypedActor {

    private Queue<PhoneInfo> waitIngList = new ArrayDeque<>();

    private boolean isWait;


    private ActorRef actorRef;

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof PhoneInfo) {
            PhoneInfo info = (PhoneInfo) message;
            if (isWait && waitIngList.size() > 0) {
                waitIngList.add(info);
            } else {
                callPhone(info);
            }
        } else if (message instanceof PhoneMessage) {
            PhoneMessage phoneMessage = (PhoneMessage) message;
            PhoneMessage.MessageState phoneMessageState = phoneMessage.getState();
            if (PhoneMessage.MessageState.Connected.equals(phoneMessageState)) {
                isWait = true;
            } else {
                isWait = false;
            }

            if (!isWait) {
                callPhone(waitIngList.poll());
            }

        } else {
            unhandled(message);
        }

    }

    private void callPhone(PhoneInfo info) {
        if (info == null) {
            return;
        }
        if (info.getPhoneNum() != null && CommonUtil.isPhoneNum(info.getPhoneNum())) {
            System.out.println("准备：" + info.getPhoneNum());
            info.setPhoneType("C");
            getActorRef().tell(info, getSelf());
        }
    }

    private ActorRef getActorRef() {
        if (actorRef == null) {
            Props props = Props.create(PhoneActor.class);
            actorRef = getContext().actorOf(props);
        }
        return actorRef;
    }
}
