package com.trailblazer.service.impl;

import com.trailblazer.pojo.BaseLogInfo;
import com.trailblazer.service.SpringBeanService;
import org.springframework.stereotype.Service;

/*
 * 文件名： DemoServiceImpl.java
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
@Service(value = "springBeanService")
public class SpringBeanServiceImpl implements SpringBeanService {

    @Override
    public int insert(BaseLogInfo baseLogInfo) {
        System.out.println(baseLogInfo.toString());
        return 100;
    }
}
