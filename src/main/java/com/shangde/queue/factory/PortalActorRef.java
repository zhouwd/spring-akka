package com.shangde.queue.factory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.shangde.queue.actor.PortalActor;
import com.typesafe.config.ConfigFactory;

/*
 * 文件名： ActorFactory.java
 * 
 * 工程名称: spring-akka
 *
 * 创建消息的入口。
 *
 * 创建日期： 2016年04月21日
 *
 * Copyright(C) 2015, by Shangde
 *
 * 原始作者: zhouwendong
 *
 */
public class PortalActorRef {

    private static ActorRef portalActorRef;

    private PortalActorRef() {
    }

    public static ActorRef getDefaultActorRef() {
        if (portalActorRef == null) {
            ActorSystem system = ActorSystem.create("ServerApp", ConfigFactory.load("akka.conf/server").getConfig("ServerSocketApp"));
            portalActorRef = system.actorOf(Props.create(PortalActor.class), "mainActor");
        }
        return portalActorRef;
    }

}
