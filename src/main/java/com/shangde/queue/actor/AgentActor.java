package com.shangde.queue.actor;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.shangde.queue.message.EventMessages;
import com.shangde.queue.message.PhoneInfoMessage;
import com.shangde.queue.message.PhoneStateMessage;
import com.shangde.queue.message.RuleInfoMessage;
import com.shangde.util.CommonUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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

    private Queue<PhoneInfoMessage> waitIngQueue = new ArrayDeque<>();

    private List<RuleInfoMessage> ruleInfoMessageList = new ArrayList<>();

    private List<PhoneInfoMessage> finishList = new ArrayList<>();

    private boolean isWait;

    private ActorRef actorRef;

    @Override
    public void onReceive(Object message) throws Exception {
        
        System.out.println("AgentActor.getSelf():" + getSelf().path());
        System.out.println("AgentActor.getSender():" + getSender().path());
        if (message instanceof PhoneInfoMessage) {
            PhoneInfoMessage info = (PhoneInfoMessage) message;
            if (isWait && waitIngQueue.size() > 0) {
                waitIngQueue.add(info);
            } else {
                callPhone(info);
            }
        } else if (message instanceof PhoneStateMessage) {
            //当电话拨打结束，重新从队列中获取要拨打的内容。
            PhoneStateMessage phoneMessage = (PhoneStateMessage) message;
            PhoneStateMessage.MessageState phoneMessageState = phoneMessage.getState();
            isWait = PhoneStateMessage.MessageState.Connected.equals(phoneMessageState);

            if (!isWait) {
                callPhone(waitIngQueue.poll());
            }
        } else if (message instanceof RuleInfoMessage) {
            ruleInfoMessageList.clear();
            ruleInfoMessageList.add((RuleInfoMessage) message);
        } else if (message instanceof EventMessages.ClearCache) {
            waitIngQueue.clear();
        } else {
            unhandled(message);
        }

    }

    private void orderWaitIngQueue(){

    }

    private void callPhone(PhoneInfoMessage info) {
        if (info == null) {
            return;
        }
        if (info.getPhoneNum() != null && CommonUtil.isPhoneNum(info.getPhoneNum())) {
            System.out.println("AgentActor.class 准备：" + info.getPhoneNum());
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
