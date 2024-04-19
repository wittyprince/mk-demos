package com.mk.demos.spring.exception.exception;

/**
 * CustomException
 *
 * @author WangChen
 * Created on 2024/4/18
 * @since 1.0
 */
public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }
}
