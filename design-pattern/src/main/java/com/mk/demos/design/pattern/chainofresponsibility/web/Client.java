package com.mk.demos.design.pattern.chainofresponsibility.web;

/**
 * filter 测试类
 * 模拟Servlet Filter(先入后出)
 *
 * 实现的效果是：
 * 请求的时候，依次经过自定义的filter处理，
 * 返回的时候，安装与处理时相反的顺序，最后处理request的filter最先处理response
 *
 * @author WangChen
 * Created on 2021/1/17 14:36
 * @since 1.0
 */
public class Client {

    public static void main(String [] args){
        String msg = "这是一条敏感信息SQL，<script>.";
        Request request = new Request();
        request.setRequestMsg(msg);
        Response response = new Response();
        response.setResponseMsg("response");

        FilterChain scripFilter = new ScriptFilter();
        FilterChain sensitiveFilter = new SensitiveFilter();
        FilterChain sqlFilter = new SQLFilter();

        scripFilter.setNextFilter(sensitiveFilter);
        sensitiveFilter.setNextFilter(sqlFilter);

        scripFilter.doFilter(request, response);

        System.out.println(request.getRequestMsg());
        System.out.println(response.getResponseMsg());

    }
}
