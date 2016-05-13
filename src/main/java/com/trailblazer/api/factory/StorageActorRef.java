package com.trailblazer.api.factory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.typesafe.config.ConfigFactory;

/*
 * 文件名： Persistence.java
 * 
 * 工程名称: spring-akka
 *
 * 为所有的接口提供统一的数据持久化Actor。
 *
 * 创建日期： 2016年04月25日
 *
 * Copyright(C) 2015, by Shangde
 *
 * 原始作者: zhouwendong
 *
 */
public class StorageActorRef {

    private static ActorRef portalActorRef;

    public static ActorRef getDefaultActorRef() {
        if (portalActorRef == null) {
            ActorSystem system = ActorSystem.create("DBServerApp", ConfigFactory.load("akka.conf/server").getConfig("DBServerSocketApp"));
            portalActorRef = system.actorOf(Props.create(StorageActor.class), "storageActor");
        }
        return portalActorRef;
    }

}

class StorageActor extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        //TODO put the message into db.
    }

}
