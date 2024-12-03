package com.mk.demos.tx.service;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

/**
 * DependsOnA
 *
 * @author WangChen
 * Created on 2024/12/3
 * @since 1.0
 */
@Service
@DependsOn("dependsOnB")
// 这里与DependsOnB互相依赖，会导致循环依赖，抛异常
public class DependsOnA {
}
