package com.trailblazer.pojo;

public class BaseLogInfo {


    private String logSource;

    private String message;

    public BaseLogInfo(String logSource, String message) {
        this.logSource = logSource;
        this.message = message;
    }

    public String getLogSource() {
        return logSource;
    }

    public void setLogSource(String logSource) {
        this.logSource = logSource;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseLogInfo{" +
                "logSource='" + logSource + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
