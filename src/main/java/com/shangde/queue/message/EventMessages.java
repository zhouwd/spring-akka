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
