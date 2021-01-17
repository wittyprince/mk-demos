package com.mk.demos.design.pattern.chainofresponsibility;

/**
 * filter过滤器
 *
 * @author WangChen
 * Created on 2021/1/17 13:00
 * @since 1.0
 */
public interface Filter {

    /**
     * 具体的处理逻辑
     */
    String doFilter(String msg);
}
