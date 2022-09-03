package com.mk.demos.spring.boot.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author muyuer 182443947@qq.com
 * @version 1.0
 * @date 2019-07-24 08:51
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class SocketMessage {
    private String message;
    private Date sendDate;

    private String roomId;

    public SocketMessage() {
    }

    public SocketMessage(String message, String roomId, Date sendDate) {
        this.message = message;
        this.roomId = roomId;
        this.sendDate = sendDate;
    }
}
