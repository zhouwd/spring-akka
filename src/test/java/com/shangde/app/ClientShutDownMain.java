package com.shangde.app;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.shangde.pojo.PhoneInfo;
import com.typesafe.config.ConfigFactory;

/*
 * 文件名： RemoteMain.java
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
public class ClientShutDownMain {
	public static void main(String[] args) {
		/*根据配置,找到System*/
		ActorSystem system = ActorSystem.create("ClientApp", ConfigFactory.load("client").getConfig("ClientSocketApp"));
		ActorRef remoteActor = system.actorFor("akka.tcp://ServerApp@127.0.0.1:2552/user/mainActor");
		PhoneInfo remote = new PhoneInfo();
		remote.setAgentName("san3");
		remote.setLegionId(2);
		remote.setGroupId(203);
		remote.setPhoneNum("18799994444");
		remote.setStudentName("小七");
		remoteActor.tell(remote,ActorRef.noSender());
//		remoteActor = system.actorFor("akka.tcp://ServerApp@127.0.0.1:2552/user/mainActor/legion_1/group_109/");
//		system.stop(remoteActor);
//		remote = new PhoneInfo();
//		remote.setAgentName("san6");
//		remote.setLegionId(1);
//		remote.setGroupId(109);
//		remote.setPhoneNum("18799996666");
//		remote.setStudentName("小六");
//		remoteActor.tell(remote,ActorRef.noSender());
		System.out.println(remoteActor.isTerminated());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(remoteActor.isTerminated());
		System.exit(0);
	}
}
