package com.mk.demos.spring.boot.websocket;

import lombok.Data;

/**
 * response
 *
 * @author WangChen
 * Created on 2022/9/3
 * @since 1.0
 */
@Data
public class DemoResponse {

    private Integer status;
    private String msg;

    public DemoResponse() {
    }

    public DemoResponse(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
