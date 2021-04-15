package com.mk.demos.spring.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

/**
 * MessageSource
 *
 * @author WangChen
 * Created on 2021/4/15 20:53
 * @since 1.0
 */
@Component
public class MyMessageSource implements MessageSourceAware {

    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }
}
