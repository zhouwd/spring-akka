package com.shangde.pojo;

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
public class AgentInfo implements Serializable {

    private String emNo;

    private String seatNo;

    private Queue<PhoneInfo> phoneInfoQueue;

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

    public Queue<PhoneInfo> getPhoneInfoQueue() {
        return phoneInfoQueue;
    }

    public void setPhoneInfoQueue(Queue<PhoneInfo> phoneInfoQueue) {
        this.phoneInfoQueue = phoneInfoQueue;
    }
}
