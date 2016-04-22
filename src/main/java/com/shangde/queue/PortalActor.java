package com.shangde.queue;

import java.util.HashMap;
import java.util.Map;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.shangde.pojo.PhoneInfo;

/*
 * 文件名： LegionActor.java
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
public class PortalActor extends UntypedActor {

	private Map<String, ActorRef> actorRefMap = new HashMap<>();

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof PhoneInfo) {
			PhoneInfo phoneInfo = (PhoneInfo) message;
			Props props = Props.create(LegionActor.class);
			String actorName = "legion_" + phoneInfo.getLegionId().toString();
			ActorRef actorRef = actorRefMap.get(actorName);
			if (actorRef == null) {
				actorRef = getContext().actorOf(props, actorName);
				actorRefMap.put(actorName, actorRef);
			}

			actorRef.tell(phoneInfo, getSelf());

		} else {
			unhandled(message);
		}
	}

}
