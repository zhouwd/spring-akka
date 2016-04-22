package com.shangde.queue;

import java.util.HashMap;
import java.util.Map;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.shangde.pojo.PhoneInfo;

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
		if (message instanceof PhoneInfo) {
			PhoneInfo phoneInfo = (PhoneInfo) message;
			Props props = Props.create(GroupActor.class);

			String actorName = "group_" + phoneInfo.getGroupId();

			ActorRef actorRef = actorRefMap.get(actorName);
			if (actorRef == null) {
				actorRef = getContext().actorOf(props, actorName);
				actorRefMap.put(actorName, actorRef);
			}

			actorRef.tell(phoneInfo, getSelf());

		} else if (message instanceof String && "EOF".equals(message.toString())) {
			System.out.println("关闭该队列");
			getContext().system().shutdown();

		} else {
			unhandled(message);
		}
	}


}
