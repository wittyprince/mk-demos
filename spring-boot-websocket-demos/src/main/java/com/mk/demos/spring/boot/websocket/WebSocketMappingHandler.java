package com.mk.demos.spring.boot.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ip -> userId 映射
 *
 * @author WangChen
 * Created on 2022/9/4
 * @since 1.0
 */
@Slf4j
@Component
public class WebSocketMappingHandler {

    private final String IP_SESSIONS_HASH = "IP_SESSION_HASH";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询满足条件的ip
     */
    private List<String> getMatchedIpList(String uid) {
        List<String> ipList = new ArrayList<>();
        HashOperations<String, String, Set<String>> hashOperations = redisTemplate.opsForHash();
        Map<String, Set<String>> map = hashOperations.entries(IP_SESSIONS_HASH);
        map.forEach((k, v) -> {
            if (v != null && v.contains(uid)) {
                ipList.add(k);
            }
        });
        return ipList;
    }

    /** {"uid":{"ip", "ip"}} */
    private Map<String, List<String>> getMatchedIpList(List<String> uids) {
        return null;
    }

    private String getIp() {
        String ip = "";
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            ip = localHost.getHostAddress();
            log.info("ip:{}", ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }
}
