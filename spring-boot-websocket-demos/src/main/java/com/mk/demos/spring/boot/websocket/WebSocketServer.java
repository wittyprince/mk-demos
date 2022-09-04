package com.mk.demos.spring.boot.websocket;

import com.alibaba.fastjson.JSONObject;
import com.mk.demos.spring.boot.websocket.spring.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.LongAdder;

/**
 * websocket server服务端处理器
 *
 * @author WangChen
 * Created on 2022/9/3
 * @since 1.0
 */
@Slf4j
@Component
@ServerEndpoint("/web/socket/{roomId}/{uid}")
public class WebSocketServer {

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static LongAdder onlineCount = new LongAdder();
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的WebSocket对象。
     */
    private static CopyOnWriteArraySet<Session> sessionSet = new CopyOnWriteArraySet<>();

    /** 存放所有在线的客户端, 每个用户对应的session {"uid" : session}*/
    public static Map<String, Session> uidSessionMap = new ConcurrentHashMap<>();
    /** {session : "uid"} */
    public static Map<Session, String> sessionUidMap = new ConcurrentHashMap<>();

    /** {"roomId": {"Session", "Session"}} */
    private static final Map<String, CopyOnWriteArraySet<Session>> roomSessionMap = new ConcurrentHashMap<>();
    /** {"roomId": {"uid", "uid"}} */
    private static Map<String, CopyOnWriteArraySet<String>> roomUidSetMap = new ConcurrentHashMap<>();
    /** {"uid": {"roomId", "roomId"}} */
    private static Map<String, CopyOnWriteArraySet<String>> uidRoomSetMap = new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     * 类属性，是共享变量，多线程访问会有问题
     */
//    private Session session;

    /**
     * 接收roomId
     */
//    private String roomId = "";

    /**
     * 即使是同一个窗口，每次发送新消息到服务端，服务端均会分配新线程来处理，
     * 所以这里 存放的ThreadLocal变量 只能是在方法调用传递到其他类的方法中时，才能使用，
     * 本类中对应新请求存放的ThreadLocal<Session>没有意义。
     */
//    private ThreadLocal<Session> localSession = new ThreadLocal<>();


    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
//    public void onOpen(Session session, EndpointConfig config, @PathParam("sid") String sid) {
    public void onOpen(Session session, @PathParam("roomId") String roomId, @PathParam("uid") String uid) {
//        this.session = session;
        uidSessionMap.put(uid, session);
        sessionUidMap.put(session, uid);
//        //加入set中
        sessionSet.add(session);
        this.addToRoomSession(roomId, session);
//        this.roomId = roomId;
        //在线数加1
        addOnlineCount();
        log.info("有新窗口开始监听:" + roomId + ",当前在线人数为" + getOnlineCount());
        String msg = "连接成功!" + ", 线程id: " +Thread.currentThread().getId();
        sendOneMessage(msg, uid, uid);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
//    public void onClose(Session session, CloseReason closeReason) {
    public void onClose(Session session, CloseReason closeReason) {
        sessionSet.remove(session);
        subOnlineCount();
        log.info("closeReason: " + closeReason.toString());
        log.info("有一连接关闭！当前在线人数为: " + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到来自窗口" + "的信息:" + message);
        sendOtherMessage(message, session);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误...");
        error.printStackTrace();
    }


    /**
     * 实现服务器主动推送
     * 此为单点消息
     */
    public static void sendOneMessage(String message, String from, String to) {
//        this.session.getBasicRemote().sendText(message);
        log.info("[单点消息] from:" + from + ", to:"+ to + ", msg:" + message);
        Session session = uidSessionMap.get(to);
        if (session != null) {
            session.getAsyncRemote().sendText(message);
        }
//        The remote endpoint was in state [STREAM_WRITING] which is an invalid state for called method
//        ConcurrentWebSocketSessionDecorator
    }

    public static void sendOtherMessage(String message, Session session){
//        this.session.getBasicRemote().sendText(message);
        SocketMessage sm = JSONObject.parseObject(message, SocketMessage.class);
        String roomId = sm.getRoomId();
        CopyOnWriteArraySet<Session> sessions = roomSessionMap.get(roomId);
//        String str = JSON.toJSONString(sessions);
//        CopyOnWriteArraySet<Session> copyOnWriteArraySet = JSONObject.parseObject(str, CopyOnWriteArraySet.class);
//        copyOnWriteArraySet.remove(session);
        sessions.forEach(to -> {
            try {
                if (to.isOpen()) {
                    to.getBasicRemote().sendText(message);
//                    to.getAsyncRemote().sendText(message);
                } else {
                    sessions.remove(to);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 实现服务器主动推送
     */
    public static void sendAllMessage(String message, String from, List<Session> tos) {
        tos.forEach(to -> to.getAsyncRemote().sendText(message));
    }

    /**
     * 群发自定义消息
     */
    public static void sendInfo(String roomId, SocketMessage message) throws IOException {
        log.info("推送消息到窗口" + roomId + "，推送内容:" + message);
        CopyOnWriteArraySet<Session> sessions = roomSessionMap.get(roomId);
        if (sessions != null && sessions.size() > 0) {
            sendAllMessage(JSONObject.toJSONString(message), "", new ArrayList<>(sessions));
        }

        RedisTemplate<String, Object> redisTemplate = SpringContextHolder.getBean("redisTemplate", RedisTemplate.class);
        redisTemplate.convertAndSend("CHANNEL_XXX", new DemoRequest("21", 123L, "wc", "mssg"));
        log.info("session..." );
    }

    // 此为广播消息
    public void sendRoomMsg(String message, String roomId, String from) {
        System.out.println("【websocket消息】广播消息:" + roomId + "--" + message);
        CopyOnWriteArraySet<Session> sessionSet = roomSessionMap.get(roomId);
        sendAllMessage(message, from, new ArrayList<>(sessionSet));
    }

    private static /*synchronized*/ long getOnlineCount() {
        return onlineCount.longValue();
    }

    private static /*synchronized*/ void addOnlineCount() {
        WebSocketServer.onlineCount.increment();
    }

    private static /*synchronized*/ void subOnlineCount() {
        WebSocketServer.onlineCount.decrement();
    }

    private synchronized void addToRoomSession(String roomId, Session session) {
        CopyOnWriteArraySet<Session> sessionSet = roomSessionMap.get(roomId);
        if (sessionSet == null) {
            sessionSet = new CopyOnWriteArraySet<>();
        }
        sessionSet.add(session);
        roomSessionMap.put(roomId, sessionSet);
    }

    private void removeFromRoomSession(Session session) {
        String uid = sessionUidMap.get(session);

    }

}
