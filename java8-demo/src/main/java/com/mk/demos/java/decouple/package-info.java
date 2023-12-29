package com.mk.demos.java.decouple;

// 解耦
//              | 中间抽象层         | 拦截器            | 事件流模式
//        ---   |---                 |---                |---
//        应用层 | 面向接口动态绑定   |interceptor拦截器  |mediator中介模式
//        架构层 | Naming解析动态绑定 |proxy代理          |broker消息模式

