package com.shangde.queue.message;

import java.io.Serializable;
import java.util.Date;

public interface EventMessages {
    class EventMessage implements Serializable {
        private String opPerson;
        private Date date;

        public String getOpPerson() {
            return opPerson;
        }

        public void setOpPerson(String opPerson) {
            this.opPerson = opPerson;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }

    class OperateActor extends  EventMessage{
        private boolean runState;

        public boolean isRunState() {
            return runState;
        }

        public void setRunState(boolean runState) {
            this.runState = runState;
        }
    }

    /**
     * 负责告知创建军团队列。<code>PortalActorRef<code/>中创建该军团队列。
     */
    public static class InitLegionActor extends OperateActor{
    }

    /**
     * 初始化指定军团下的所有组队列。可以创建，也可以关闭。
     * 如果该组所在的军团队列尚未初始化，那么无法初始化该军团所有的组队列。
     */
    public static class InitGroupActor extends OperateActor{

    }

    /**
     * 初始化指定组下的所有咨询师队列。可以创建，也可以关闭。
     * 如果该组队列尚未初始化，那么无法初始化该组所有的咨询师队列。
     */
    public static class InitAgentActor extends OperateActor{

    }

    /**
     * 清空队列
     */
    public static class ClearCache extends EventMessage {

        private Integer legionId;
        private Integer groupId;
        private String agentName;

        private OperateObject operateObject;

        public ClearCache(Integer legionId, Integer groupId, String agentName, OperateObject operateObject) throws Exception {
            String msg = checkNull(legionId, groupId, agentName, operateObject);
            if (msg != null) {
                throw new Exception(msg);
            }
            this.legionId = legionId;
            this.groupId = groupId;
            this.agentName = agentName;
            this.operateObject = operateObject;
        }


        public Integer getLegionId() {
            return legionId;
        }

        public Integer getGroupId() {
            return groupId;
        }

        public String getAgentName() {
            return agentName;
        }

        public OperateObject getOperateObject() {
            return operateObject;
        }

        private String checkNull(Integer legionId, Integer groupId, String agentName, OperateObject operateObject) {
            if (operateObject.equals(OperateObject.Agent) && (legionId == null || groupId == null || agentName == null)) {
                return "LegionID, GroupID and AgentName can't null";
            }
            if (operateObject.equals(OperateObject.Group) && (legionId == null || groupId == null)) {
                return "LegionID and AgentName can't null";
            }

            if (operateObject.equals(OperateObject.Agent) && (legionId == null)) {
                return "LegionID can't null";
            }
            return null;
        }

        public static enum OperateObject {
            Legion, Group, Agent
        }

    }


}
