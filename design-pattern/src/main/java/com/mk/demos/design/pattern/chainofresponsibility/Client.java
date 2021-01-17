package com.mk.demos.design.pattern.chainofresponsibility;

/**
 * filter测试类
 *
 * @author WangChen
 * Created on 2021/1/17 13:26
 * @since 1.0
 */
public class Client {

    public static void main(String [] args){
        String msg = "这是一条敏感信息SQL，<script>.";

        FilterChain chain = new FilterChain();
        chain.addFilter(new ScriptFilter())
        .addFilter(new SensitiveFilter());
        FilterChain chain2 = new FilterChain();
        chain2.addFilter(new SQLFilter());
        chain.addFilter(chain2);

        MessageProcessor processor = new MessageProcessor();
        processor.setMessage(msg);
        processor.setChain(chain);
        String s = processor.doProcess();

        System.out.println(s);

    }
}
