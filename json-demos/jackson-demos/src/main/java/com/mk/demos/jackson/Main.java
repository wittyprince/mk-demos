package com.mk.demos.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mk.demos.jackson.dto.Inner;
import com.mk.demos.jackson.dto.Outer;
import com.mk.demos.jackson.dto.SubInner;

/**
 * 序列化
 *
 * @author WangChen
 * Created on 2022/10/18
 * @since 1.0
 */
public class Main {

    public static void main(String[] args) {

        Outer<Inner> outer1 = new Outer<>();
        Inner inner = new Inner();
        inner.setName("i1");
        inner.setAge(1);
        outer1.setInner(inner);
        outer1.setName("o1");

        Main main = new Main();
        String serialization = main.serialization(outer1);
        System.out.println("serialization:" + serialization);
        Outer<Inner> deserialization = main.deserialization(serialization);
        Inner inner1 = deserialization.getInner();
        System.out.println("inner1.name:" + inner1.getName());


        Outer<SubInner> outer2 = new Outer<>();
        outer2.setName("o2");
        SubInner subInner = new SubInner();
        subInner.setName("subi2");
        subInner.setAge(2);
        subInner.setSub("sub2");
        outer2.setInner(subInner);
        String serialization2 = main.serialization(outer2);
        System.out.println("serialization2:" + serialization2);
        Outer<SubInner> deserialization2 = main.deserialization(serialization2);
        SubInner subInner2 = deserialization2.getInner();
        System.out.println("subInner2.sub:" + subInner2.getSub());

    }

    private <T> String serialization(Outer<T> messageBody) {
        String outer = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            outer = objectMapper.writeValueAsString(messageBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return outer;
    }

    private <T> Outer<T> deserialization(String jsonString) {
        Outer<T> outer = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            @SuppressWarnings("unchecked")
            TypeReference<Outer<T>> typeReference1 = getTypeReference();
            outer = objectMapper.readValue(jsonString, typeReference1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return outer;
    }

    protected TypeReference getTypeReference() {
        return new TypeReference<Outer<Inner>>() {
        };
    }

    protected TypeReference getTypeReference2() {
        return new TypeReference<Outer<SubInner>>() {
        };
    }
}
