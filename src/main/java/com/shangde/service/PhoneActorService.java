package com.shangde.service;

import java.util.Queue;

import com.shangde.pojo.PhoneInfo;

/*
 * 文件名： DemoService.java
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
public interface PhoneActorService {

    /**
     * 获取队列信息
     *
     * @return
     */
    Queue<PhoneInfo> getPhoneInfo();

    /**
     * 发送消息
     *
     * @param phoneInfo 电话信息
     */
    void sendPhoneInfo(PhoneInfo phoneInfo);

    /**
     * 批量发送队列消息
     *
     * @param phoneInfoQueue 批量的队列消息
     */
    void sendQueuePhoneInfo(Queue<PhoneInfo> phoneInfoQueue);


}
