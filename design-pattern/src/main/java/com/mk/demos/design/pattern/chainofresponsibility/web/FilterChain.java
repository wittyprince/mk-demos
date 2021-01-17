package com.mk.demos.design.pattern.chainofresponsibility.web;

/**
 * filter chain
 *
 * @author WangChen
 * Created on 2021/1/17 14:27
 * @since 1.0
 */
public abstract class FilterChain implements Filter{

    protected FilterChain nextFilter;

    public FilterChain getNextFilter() {
        return nextFilter;
    }

    public void setNextFilter(FilterChain nextFilter) {
        this.nextFilter = nextFilter;
    }
}
