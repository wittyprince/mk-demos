package com.mk.demos.design.pattern.chainofresponsibility;

/**
 * sql filter
 *
 * @author WangChen
 * Created on 2021/1/17 14:00
 * @since 1.0
 */
public class SQLFilter implements Filter{
    @Override
    public String doFilter(String msg) {
        return msg.replaceAll("SQL", "sql");
    }
}
