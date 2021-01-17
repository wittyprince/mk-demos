package com.mk.demos.design.pattern.chainofresponsibility.web;

/**
 * 需要处理的请求
 *
 * @author WangChen
 * Created on 2021/1/17 13:14
 * @since 1.0
 */
public class Request {
    private String requestMsg;

    public String getRequestMsg() {
        return requestMsg;
    }

    public void setRequestMsg(String requestMsg) {
        this.requestMsg = requestMsg;
    }
}
