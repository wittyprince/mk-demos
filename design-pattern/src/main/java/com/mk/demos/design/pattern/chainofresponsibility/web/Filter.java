package com.mk.demos.design.pattern.chainofresponsibility.web;

/**
 * web filter 过滤器
 *
 * @author WangChen
 * Created on 2021/1/17 14:26
 * @since 1.0
 */
public interface Filter {

    /**
     * 定义处理方法
     */
    void doFilter(Request request, Response response);
}
