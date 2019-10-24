package com.mk.demos.spring.boot.exception;

/**
 * ApiVersionDiscardException
 *
 * @author WangChen
 * Created on 2019/10/24 21:50
 * @since 1.0
 */
public class ApiVersionDiscardException extends RuntimeException {
    public ApiVersionDiscardException(String message) {
        super(message);
    }
}
