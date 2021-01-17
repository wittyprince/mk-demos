package com.mk.demos.design.pattern.chainofresponsibility.web;

/**
 * sensitive filter
 *
 * @author WangChen
 * Created on 2021/1/17 15:12
 * @since 1.0
 */
public class SensitiveFilter extends FilterChain{
    @Override
    public void doFilter(Request request, Response response) {
        String msg = request.getRequestMsg().replaceAll("敏感", "和谐");
        request.setRequestMsg(msg);
        if (super.nextFilter != null) {
            super.nextFilter.doFilter(request, response);
        }
        response.setResponseMsg(response.getResponseMsg() + "--SensitiveFilter-response--");

    }
}
