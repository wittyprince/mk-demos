package com.mk.demos.design.pattern.chainofresponsibility;

/**
 * 处理敏感信息的 filter
 *
 * @author WangChen
 * Created on 2021/1/17 13:31
 * @since 1.0
 */
public class SensitiveFilter implements Filter {
    @Override
    public String doFilter(String msg) {
        return msg.replaceAll("敏感", "和谐");
    }
}
