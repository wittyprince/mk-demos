package com.mk.demos.spring.boot.websocket.spring_integration;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;

/**
 * WsHandler
 *
 * 说明
 * 通过继承 TextWebSocketHandler 类并覆盖相应方法，
 * 可以对 websocket 的事件进行处理，这里可以同原生注解的那几个注解连起来看
 *
 * afterConnectionEstablished 方法是在 socket 连接成功后被触发，同原生注解里的 @OnOpen 功能
 * **afterConnectionClosed **方法是在 socket 连接关闭后被触发，同原生注解里的 @OnClose 功能
 * **handleTextMessage **方法是在客户端发送信息时触发，同原生注解里的 @OnMessage 功能
 *
 * @author WangChen
 * Created on 2023/7/27
 * @since 1.0
 */
@Component
public class MyWsAuthHandler extends TextWebSocketHandler {

    /**
     * socket 建立成功事件
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Object token = session.getAttributes().get("token");
        if (token != null) {
            // 用户连接成功，放入在线用户缓存
            WsSessionManager.add(token.toString(), session);
        } else {
            throw new RuntimeException("用户登录已经失效!");
        }
    }

    /**
     * 接收消息事件
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 获得客户端传来的消息
        String payload = message.getPayload();
        Object token = session.getAttributes().get("token");
        System.out.println("server 接收到 " + token + " 发送的 " + payload);
        session.sendMessage(new TextMessage("server 发送给 " + token + " 消息 " + payload + " " + LocalDateTime.now().toString()));
    }

    /**
     * socket 断开连接时
     *
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        Object token = session.getAttributes().get("token");
        if (token != null) {
            // 用户退出，移除缓存
            WsSessionManager.remove(token.toString());
        }
    }
}
