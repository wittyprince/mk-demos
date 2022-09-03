package com.mk.demos.spring.boot.websocket;

import lombok.Data;

/**
 * request
 *
 * @author WangChen
 * Created on 2022/9/3
 * @since 1.0
 */
@Data
public class DemoRequest {

    private String roomId;
    private Long userId;
    private String username;
    private String msg;
}
