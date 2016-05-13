package com.trailblazer.queue.message;

import java.io.Serializable;

/*
 * 文件名： ResultInfo.java
 * 
 * 工程名称: spring-akka
 *
 * Shang De
 *
 * 创建日期： 2016年04月25日
 *
 * Copyright(C) 2015, by Shangde
 *
 * 原始作者: zhouwendong
 *
 */
public class ResultInfoMessage implements Serializable {

    private String remark;

    private PhoneInfoMessage phoneInfoMessage;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public PhoneInfoMessage getPhoneInfoMessage() {
        return phoneInfoMessage;
    }

    public void setPhoneInfoMessage(PhoneInfoMessage phoneInfoMessage) {
        this.phoneInfoMessage = phoneInfoMessage;
    }
}
