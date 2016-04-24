package com.shangde.queue.actor;

import java.util.Date;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import com.shangde.queue.message.PhoneMessage;
import com.shangde.pojo.PhoneInfo;

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

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof PhoneInfo) {
			PhoneInfo phoneInfo = (PhoneInfo) message;
			phoneInfo.setPhoneType("Y");
			System.out.println(getSelf().path() + " message=" + message.toString());
			System.out.println(new Date() + ":拨打中：" + phoneInfo.getPhoneNum());
			PhoneMessage phoneMessage = null;
			if (phoneInfo.getPhoneNum().equals("18799993333")) {
				Thread.sleep(10000);
				phoneMessage = new PhoneMessage(phoneInfo, PhoneMessage.MessageState.CannotConnected);
				getSender().tell(phoneMessage, ActorRef.noSender());
			} else if (phoneInfo.getPhoneNum().equals("18799994444")) {
				Thread.sleep(2000);
				phoneMessage = new PhoneMessage(phoneInfo, PhoneMessage.MessageState.Connected);
				getSender().tell(phoneMessage, ActorRef.noSender());
				Thread.sleep(8000);
				phoneMessage = new PhoneMessage(phoneInfo, PhoneMessage.MessageState.HangUp);
				getSender().tell(phoneMessage, ActorRef.noSender());
			} else {
				Thread.sleep(10000);
				phoneMessage = new PhoneMessage(phoneInfo, PhoneMessage.MessageState.Reject);
				getSender().tell(phoneMessage, ActorRef.noSender());
			}
			System.out.println(new Date() + ":拨打结束：" + phoneInfo.getPhoneNum());


		} else {
			unhandled(message);
		}

	}

}
