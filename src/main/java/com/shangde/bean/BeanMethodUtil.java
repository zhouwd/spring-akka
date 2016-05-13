package com.shangde.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.shangde.queue.pojo.BeanObjClass;


public class BeanMethodUtil {

    public static Object runMethod(BeanObjClass beanObj) {
        Object bean = SpringContextUtil.getBean(beanObj.getBeanName());
        try {
            Class<?> classType = beanObj.getBeanClass();
            Method method = classType.getMethod(beanObj.getMethodName(), beanObj.getParams());
            Object o = method.invoke(bean, beanObj.getParamValues());
            System.out.println(o);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


}
