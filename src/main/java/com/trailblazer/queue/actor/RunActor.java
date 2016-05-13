package com.trailblazer.queue.actor;

import akka.actor.UntypedActor;
import com.trailblazer.bean.BeanMethodUtil;
import com.trailblazer.queue.pojo.BeanObjClass;

public class RunActor  extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        if(o instanceof BeanObjClass){
            BeanMethodUtil.runMethod((BeanObjClass) o);
        }
    }
}
