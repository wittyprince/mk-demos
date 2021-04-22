package com.mk.demos.spring.propertyeditor;

import java.beans.PropertyEditorSupport;

/**
 *
 * converts string representation to ExoticType object
 *
 * @author WangChen
 * Created on 2021/4/22 20:06
 * @since 1.0
 */
public class ExoticTypeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        super.setValue(new ExoticType(text.toUpperCase()));
    }
}
