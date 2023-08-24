package com.mk.demos.logging.converter;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.mk.demos.logging.fun.Fun;

/**
 * LogbackExt
 *
 * @author WangChen
 * Created on 2023/6/5
 * @since 1.0
 */

public class LogbackExt extends MessageConverter {

    @Override
    public String convert(ILoggingEvent event) {
        String oriLogMsg = event.getFormattedMessage();
        return oriLogMsg == null ? null : Fun.convert(oriLogMsg);
//        return super.convert(event);
    }
}
