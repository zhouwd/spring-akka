package com.trailblazer.service.impl;

import akka.actor.ActorRef;
import com.trailblazer.queue.factory.PortalActorRef;
import com.trailblazer.service.MainActorService;
import org.springframework.stereotype.Service;

@Service(value = "mainActorService")
public class MainActorServiceImpl implements MainActorService {
    @Override
    public void sendMessage(Object object) {
        ActorRef defaultActorRef = PortalActorRef.getDefaultActorRef();
        defaultActorRef.tell(object, ActorRef.noSender());
    }
}
