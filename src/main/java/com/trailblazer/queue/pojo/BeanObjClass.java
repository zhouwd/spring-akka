package com.trailblazer.queue.pojo;

public class BeanObjClass {

    private String beanName;
    private Class beanClass;
    private String methodName;
    private Class[] params;
    private Object[] paramValues;

    public BeanObjClass(String beanName, Class beanClassName, String methodName, Class[] params, Object[] paramValues) {
        this.beanName = beanName;
        this.beanClass = beanClassName;
        this.methodName = methodName;
        this.params = params;
        this.paramValues = paramValues;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParams() {
        return params;
    }

    public void setParams(Class[] params) {
        this.params = params;
    }

    public Object[] getParamValues() {
        return paramValues;
    }

    public void setParamValues(Object[] paramValues) {
        this.paramValues = paramValues;
    }
}
