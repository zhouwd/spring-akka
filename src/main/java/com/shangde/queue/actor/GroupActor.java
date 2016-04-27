package com.shangde.queue.actor;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.shangde.pojo.AgentPojo;
import com.shangde.queue.message.PhoneInfoMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * 文件名： AgentActor.java
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
public class GroupActor extends UntypedActor {

    private Map<String, ActorRef> actorRefMap = new HashMap<>();

    private Map<String, List<PhoneInfoMessage>> agentMsgMap = new HashMap<>();

    private final LoggingAdapter log = Logging.getLogger(this);

    @Override
    public void onReceive(Object message) throws Exception {
        log.info(getSelf().path() + " message=" + message.toString());
//        System.out.println(GroupActor.class + "::" + message.toString());
        //获取咨询师拨打电话队列。默认加载咨询师自己的队列。当自己的队列电话打完之后，向组队列请求新的数据
        if (message instanceof PhoneInfoMessage) {
            PhoneInfoMessage info = (PhoneInfoMessage) message;
            if (info.getAgentName() == null) {
                allocateToAgent(info);
            }
            ActorRef actorRef = getAgentActorRef(info.getAgentName());
            info.setMsg("it is in GroupActor");
            System.out.println("GroupActor.getSelf():" + getSelf().path());
            System.out.println("GroupActor.getSender():" + getSender().path());
            actorRef.tell(info, getSelf());


        } else {
            unhandled(message);
        }
    }

    /**
     * 将数据分配给某一个咨询师，并将咨询师信息Set到该对象中。
     *
     * @param info
     */
    private void allocateToAgent(PhoneInfoMessage info) {
        int tempSize = Integer.MAX_VALUE;
        for (Map.Entry<String, List<PhoneInfoMessage>> stringListEntry : agentMsgMap.entrySet()) {
            int size = stringListEntry.getValue().size();
            if (size < tempSize) {
                tempSize = size;
                info.setAgentName(stringListEntry.getKey());
            }
        }
        agentMsgMap.get(info.getAgentName()).add(info);
    }

    /**
     * 初始化该组人员队列，根据班表创建，不为休息，休假的咨询师创建队列。
     *
     * @param groupId
     */
    private void initAgentActorMap(Integer groupId) {
        //1.查询排班中该组的排班情况，查询该组所有人的班表。
        List<AgentPojo> agentPojoList = new ArrayList<>();

        //2.遍历咨询师列表，并逐个检查是否已经创建队列。
        for (AgentPojo pojo : agentPojoList) {
            getAgentActorRef(pojo.getEmNo());
        }
    }

    private ActorRef getAgentActorRef(String agentName) {
        String actorName = "agent_" + agentName;
        ActorRef actorRef = actorRefMap.get(actorName);
        if (actorRef == null) {
            Props props = Props.create(AgentActor.class);
            actorRef = getContext().actorOf(props, actorName);
            actorRefMap.put(actorName, actorRef);
        }
        return actorRef;
    }
}
