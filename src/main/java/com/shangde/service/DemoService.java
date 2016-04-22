package com.shangde.service;

import java.util.Queue;

import org.springframework.stereotype.Service;

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
@Service
public interface DemoService {

	Queue<PhoneInfo> getPhoneInfo();

	void sendPhoneInfo(Queue<PhoneInfo> phoneInfoQueue);

}
