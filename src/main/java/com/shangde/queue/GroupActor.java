package com.shangde.queue;

import java.util.HashMap;
import java.util.Map;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.shangde.pojo.PhoneInfo;
import com.shangde.util.CommonUtil;

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

	@Override
	public void onReceive(Object message) throws Exception {
//		System.out.println(getSelf().path() + " message=" + message.toString());
		System.out.println(GroupActor.class + message.toString());
		//获取咨询师拨打电话队列。默认加载咨询师自己的队列。当自己的队列电话打完之后，向组队列请求新的数据
		if (message instanceof PhoneInfo) {
			PhoneInfo info = (PhoneInfo) message;
			//该方式
			Props props = Props.create(AgentActor.class);
			String actorName = "agent_" + info.getAgentName();
//				phoneInfoQueue.
			ActorRef actorRef = actorRefMap.get(actorName);
			if (actorRef == null) {
				actorRef = getContext().actorOf(props, actorName);
				actorRefMap.put(actorName, actorRef);
			}

			if (info.getPhoneNum() != null && CommonUtil.isPhoneNum(info.getPhoneNum())) {
				System.out.println("准备：" + info.getPhoneNum());
				actorRef.tell(info, getSelf());
			}
		} else {
			unhandled(message);
		}
	}
}
