package com.shangde.queue.actor;

import akka.actor.UntypedActor;
import com.shangde.bean.BeanMethodUtil;
import com.shangde.queue.pojo.BeanObjClass;

public class RunActor  extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        if(o instanceof BeanObjClass){
            BeanMethodUtil.runMethod((BeanObjClass) o);
        }
    }
}
