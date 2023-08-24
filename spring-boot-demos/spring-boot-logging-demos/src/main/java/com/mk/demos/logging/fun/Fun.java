package com.mk.demos.logging.fun;

/**
 * Fun
 *
 * @author WangChen
 * Created on 2023/6/5
 * @since 1.0
 */
public class Fun {

    public static String convert(String message) {
        return message == null ? null : "message after processing is: " + message.toUpperCase();
    }

}
