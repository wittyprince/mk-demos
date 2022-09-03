package com.mk.demos.spring.boot.websocket;

/**
 * 这里有两个问题：
 *
 * 1. 如果是单台实例，其实我们大可不必使用redis进行共享session；
 * 但如果是分布式，客户端创建的连接是随机的，可能与服务器A创建了连接，也可能是服务器B,
 * 如果仅仅将连接信息存到内存，那就有问题了
 *
 * 2. WebsocketSession 不支持序列化，所以不能直接将Session对象存储到redis中
 *
 * 这里只是其中的一种解决方法，A、B服务器的session依然保存在各自的服务器中，
 * 然后将userid、sessionId、服务端服务器的IP的关系保存在redis中；
 * 当然这个sessionId你也可以不用，你可以在拿到websocket的session的时候，
 * 给他赋予一个唯一ID,并把这个ID和websocket session存入内存，
 * 同时将该关系以及当前创建的服务器IP保存到redis中；
 *
 * 如何使用？
 * 需要发送消息的时候，根据userId从redis中获取对应的关系，
 * 再根据对应的IP转发到对用的websocket服务器上即可
 *
 * sessionId是由org.apache.tomcat.websocket.WsSession生成的一个递增的16进制并转为字符串,
 * 每次重启服务,这个id的计数又会重新从0开始。如果建立了多个通道,那他们的id可能为(0,1818,70cc).
 * 因为通道断开,对应的webSocketSession对象被释放,所以不同通道直接的id可能是不连续的.
 *
 */