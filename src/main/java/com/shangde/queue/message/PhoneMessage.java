package com.shangde.queue.message;

/*
 * 文件名： PhoneMessage.java
 * 
 * 工程名称: spring-akka
 *
 * Shang De
 *
 * 创建日期： 2016年04月22日
 *
 * Copyright(C) 2015, by Shangde
 *
 * 原始作者: zhouwendong
 *
 */
public class PhoneMessage {

//	Connected("拨通", "CONNECTED"), CannotConnected("未接通", "cannotConnected"), Reject("拒接", "reject");


    private Object message;

    private MessageState state;

    public PhoneMessage(Object message, MessageState state) {
        this.message = message;
        this.state = state;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public MessageState getState() {
        return state;
    }

    public void setState(MessageState state) {
        this.state = state;
    }

    public static enum MessageState {
        Connected, CannotConnected, Reject, HangUp
    }
}
