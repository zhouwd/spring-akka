package com.shangde.pojo;

import java.io.Serializable;

/*
 * 文件名： CallInfo.java
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
public class PhoneInfo implements Serializable {

    private Integer legionId;

    private Integer groupId;

    private String agentName;

    private String studentName;

    private String phoneType;

    private String phoneNum;

    private String callNum;

    public Integer getLegionId() {
        return legionId;
    }

    public void setLegionId(Integer legionId) {
        this.legionId = legionId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCallNum() {
        return callNum;
    }

    public void setCallNum(String callNum) {
        this.callNum = callNum;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PhoneInfo{");
        sb.append("legionId=").append(legionId);
        sb.append(", groupId=").append(groupId);
        sb.append(", agentName='").append(agentName).append('\'');
        sb.append(", phoneType='").append(phoneType).append('\'');
        sb.append(", phoneNum='").append(phoneNum).append('\'');
        sb.append(", callNum='").append(callNum).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
