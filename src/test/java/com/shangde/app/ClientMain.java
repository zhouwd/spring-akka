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
public class ClientMain {
    public static void main(String[] args) {
        /*根据配置,找到System*/
        ActorSystem system = ActorSystem.create("ClientApp", ConfigFactory.load("akka.conf/client").getConfig("ClientSocketApp"));
        final ActorRef remoteActor = system.actorFor("akka.tcp://ServerApp@127.0.0.1:2552/user/mainActor");
        PhoneInfo remote = new PhoneInfo();
        remote.setAgentName("san5");
        remote.setLegionId(1);
        remote.setGroupId(109);
        remote.setPhoneNum("18799995555");
        remote.setStudentName("小五");

        remoteActor.tell(remote, ActorRef.noSender());
    }
}
