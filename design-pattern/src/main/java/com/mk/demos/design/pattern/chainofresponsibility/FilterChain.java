package com.mk.demos.design.pattern.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器链
 *
 * @author WangChen
 * Created on 2021/1/17 13:12
 * @since 1.0
 */
public class FilterChain implements Filter {

    private List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter filter){
        this.filters.add(filter);
        return this;
    }

    @Override
    public String doFilter(String msg) {
        String result = msg;
        for (Filter f : filters) {
            result = f.doFilter(result);
        }
        return result;
    }
}
