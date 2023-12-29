package com.mk.demos.spring.boot.websocket.spring_integration;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * MyInterceptor
 *
 * 说明
 * 通过实现 HandshakeInterceptor 接口来定义握手拦截器，
 * 注意这里与上面 Handler 的事件是不同的，这里是建立握手时的事件，分为握手前与握手后，
 * 而 Handler 的事件是在握手成功后的基础上建立 socket 的连接。
 * 所以在如果把认证放在这个步骤相对来说最节省服务器资源。
 * 它主要有两个方法 beforeHandshake 与 **afterHandshake **，
 * 顾名思义一个在握手前触发，一个在握手后触发。
 *
 * @author WangChen
 * Created on 2023/7/27
 * @since 1.0
 */
@Component
public class MyInterceptor implements HandshakeInterceptor {

    /**
     * 握手前
     *
     * @param request
     * @param response
     * @param wsHandler
     * @param attributes
     * @return
     * @throws Exception
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        System.out.println("握手开始");
        // 获得请求参数
//        HashMap<String, String> paramMap = HttpUtil.decodeParamMap(request.getURI().getQuery(), "utf-8");
//        String uid = paramMap.get("token");
//        if (StrUtil.isNotBlank(uid)) {
//            // 放入属性域
//            attributes.put("token", uid);
//            System.out.println("用户 token " + uid + " 握手成功！");
//            return true;
//        }
//        System.out.println("用户登录已失效");
//        return false;
        List<String> tokenList = CollectionUtils.isEmpty(request.getHeaders().get("token")) ?
                request.getHeaders().get("sec-websocket-protocol") :
                request.getHeaders().get("token");
        attributes.put("token", tokenList);
        if (request instanceof ServletServerHttpRequest) {
            HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
            String token = servletRequest.getHeader("sec-websocket-protocol");
            if (StringUtils.hasText(token)) {
                attributes.put("token", token);
            }
            String uuid = servletRequest.getParameter("uuid");
            if (StringUtils.hasText(uuid)) {
                attributes.put("uuid", uuid);
            }
        }
        return true;
    }

    /**
     * 握手后
     *
     * @param request
     * @param response
     * @param wsHandler
     * @param exception
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        if (request instanceof ServletServerHttpRequest && response instanceof ServletServerHttpResponse) {
            HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
            HttpServletResponse servletResponse = ((ServletServerHttpResponse) response).getServletResponse();
            if (StringUtils.hasText(servletRequest.getHeader("sec-websocket-protocol"))) {
                servletResponse.setHeader("sec-websocket-protocol", servletRequest.getHeader("sec-websocket-protocol"));
            }
        }
        System.out.println("握手完成");
    }
}
