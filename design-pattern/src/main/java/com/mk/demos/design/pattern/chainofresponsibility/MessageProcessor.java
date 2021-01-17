package com.mk.demos.design.pattern.chainofresponsibility;

/**
 * 消息处理器
 *
 * @author WangChen
 * Created on 2021/1/17 14:20
 * @since 1.0
 */
public class MessageProcessor {

    private String message;
    private FilterChain chain;

    public String doProcess(){
        return this.chain.doFilter(this.message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FilterChain getChain() {
        return chain;
    }

    public void setChain(FilterChain chain) {
        this.chain = chain;
    }
}
