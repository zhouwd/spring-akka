package com.shangde.service.impl;

import akka.actor.ActorRef;
import com.shangde.queue.factory.PortalActorRef;
import com.shangde.service.MainActorService;
import org.springframework.stereotype.Service;

@Service(value = "mainActorService")
public class MainActorServiceImpl implements MainActorService {
    @Override
    public void sendMessage(Object object) {
        ActorRef defaultActorRef = PortalActorRef.getDefaultActorRef();
        defaultActorRef.tell(object, ActorRef.noSender());
    }
}
