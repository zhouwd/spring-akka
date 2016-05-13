package com.shangde.queue.message;

import java.io.Serializable;
import java.util.Queue;

/*
 * 文件名： AgentInfo.java
 * 
 * 工程名称: spring-akka
 *
 * Shang De
 *
 * 创建日期：2016年04月21日
 *
 * Copyright(C) 2015, by Shangde
 *
 * 原始作者: zhouwendong
 *
 */
public class AgentInfoMessage implements Serializable {

    private String emNo;

    private String seatNo;

    private Queue<PhoneInfoMessage> phoneInfoMessageQueue;

    public String getEmNo() {
        return emNo;
    }

    public void setEmNo(String emNo) {
        this.emNo = emNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public Queue<PhoneInfoMessage> getPhoneInfoMessageQueue() {
        return phoneInfoMessageQueue;
    }

    public void setPhoneInfoMessageQueue(Queue<PhoneInfoMessage> phoneInfoMessageQueue) {
        this.phoneInfoMessageQueue = phoneInfoMessageQueue;
    }
}
