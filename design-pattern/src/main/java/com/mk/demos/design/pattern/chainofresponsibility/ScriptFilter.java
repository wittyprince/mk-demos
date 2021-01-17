package com.mk.demos.design.pattern.chainofresponsibility;

/**
 * 处理脚本的 filter
 *
 * @author WangChen
 * Created on 2021/1/17 13:27
 * @since 1.0
 */
public class ScriptFilter implements Filter {
    @Override
    public String doFilter(String msg) {
        String result = msg.replaceAll("<", "[")
                .replaceAll(">", "]");
        return result;
    }
}
