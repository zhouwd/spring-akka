package com.shangde.app;

import java.util.ArrayDeque;
import java.util.Queue;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.shangde.pojo.PhoneInfo;
import com.shangde.queue.actor.PortalActor;
import com.typesafe.config.ConfigFactory;

/*
 * 文件名： Main.java
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
public class ServerMain {

	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("ServerApp",ConfigFactory.load("akka.conf/server").getConfig("ServerSocketApp"));
		ActorRef legionActor = system.actorOf(Props.create(PortalActor.class), "mainActor");
		for (PhoneInfo phoneInfo : getPhoneInfo()) {
			legionActor.tell(phoneInfo, legionActor);
		}
	}

	private static Queue<PhoneInfo> getPhoneInfo() {
		Queue<PhoneInfo> phoneInfoQueue = new ArrayDeque<>();
		PhoneInfo p1 = new PhoneInfo();
		p1.setAgentName("san");
		p1.setLegionId(1);
		p1.setGroupId(101);
		p1.setPhoneNum("18799991111");
		p1.setStudentName("小一");
		phoneInfoQueue.add(p1);

		PhoneInfo p2 = new PhoneInfo();
		p2.setAgentName("san2");
		p2.setLegionId(1);
		p2.setGroupId(101);
		p2.setPhoneNum("18799992222");
		p2.setStudentName("小二");
		phoneInfoQueue.add(p2);

		PhoneInfo p3 = new PhoneInfo();
		p3.setAgentName("san3");
		p3.setLegionId(2);
		p3.setGroupId(203);
		p3.setPhoneNum("18799993333");
		p3.setStudentName("小三");
		phoneInfoQueue.add(p3);
		PhoneInfo p4 = new PhoneInfo();
		p4.setAgentName("san3");
		p4.setLegionId(2);
		p4.setGroupId(203);
		p4.setPhoneNum("18799994444");
		p4.setStudentName("小四");
		phoneInfoQueue.add(p4);
		PhoneInfo p5 = new PhoneInfo();
		p5.setAgentName("san3");
		p5.setLegionId(2);
		p5.setGroupId(203);
		p5.setPhoneNum("18799995555");
		p5.setStudentName("小五");
		phoneInfoQueue.add(p5);
		PhoneInfo p6 = new PhoneInfo();
		p6.setAgentName("san3");
		p6.setLegionId(2);
		p6.setGroupId(203);
		p6.setPhoneNum("18799996666");
		p6.setStudentName("小六");
		phoneInfoQueue.add(p6);
		return phoneInfoQueue;
	}
}
