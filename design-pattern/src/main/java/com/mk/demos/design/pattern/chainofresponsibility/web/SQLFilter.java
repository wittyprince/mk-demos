package com.mk.demos.design.pattern.chainofresponsibility.web;

/**
 * sql filter
 *
 * @author WangChen
 * Created on 2021/1/17 15:14
 * @since 1.0
 */
public class SQLFilter extends FilterChain {
    @Override
    public void doFilter(Request request, Response response) {
        String msg = request.getRequestMsg().replaceAll("SQL", "sql");
        request.setRequestMsg(msg);
        if (super.nextFilter != null) {
            super.nextFilter.doFilter(request, response);
        }
        response.setResponseMsg(response.getResponseMsg() + "--SQLFilter-response--");
    }
}
