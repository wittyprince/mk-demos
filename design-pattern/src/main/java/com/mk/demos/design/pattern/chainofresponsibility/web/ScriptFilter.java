package com.mk.demos.design.pattern.chainofresponsibility.web;

/**
 * script filter
 *
 * @author WangChen
 * Created on 2021/1/17 14:44
 * @since 1.0
 */
public class ScriptFilter extends FilterChain{

    @Override
    public void doFilter(Request request, Response response) {
        String msg = request.getRequestMsg()
                .replaceAll("<", "[")
                .replaceAll(">", "]");
        request.setRequestMsg(msg);
        if (super.nextFilter != null) {
            super.nextFilter.doFilter(request, response);
        }
        response.setResponseMsg(response.getResponseMsg() + "--ScriptFilter-response--");
    }
}
