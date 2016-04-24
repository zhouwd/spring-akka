package com.shangde.util;

/*
 * 文件名： CommonUtil.java
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
public class CommonUtil {
    public static boolean isPhoneNum(String phoneNum) {
        return phoneNum != null && phoneNum.matches("[0-9]+");
    }
}
