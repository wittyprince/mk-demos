package com.mk.demos.design.pattern.chainofresponsibility.web;

/**
 * 消息处理器
 *
 * @author WangChen
 * Created on 2021/1/17 14:37
 * @since 1.0
 */
public class MessageProcessor {

    private Request request;
    private Response response;
    private FilterChain chain;

    public void doProcess(){
        chain.doFilter(request, response);
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public FilterChain getChain() {
        return chain;
    }

    public void setChain(FilterChain chain) {
        this.chain = chain;
    }
}
