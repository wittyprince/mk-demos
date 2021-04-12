package com.mk.demos.spring.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.mk.demos.spring.mvc.config.RootConfig;
import com.mk.demos.spring.mvc.config.WebConfig;

/**
 * Java Config 方式 实现 WebApplicationInitializer
 *
 * @author WangChen
 * Created on 2021/4/11 19:48
 * @since 1.0
 */
public class AnnotationWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        // 1. 配置 root ApplicationContext
        // AnnotationConfigWebApplicationContext 不是 AnnotationConfigApplicationContext
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);

        container.addListener(new ContextLoaderListener(rootContext));

        // 2. 配置 web ApplicationContext
        //
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebConfig.class);

        ServletRegistration.Dynamic dispatcherServlet = container.addServlet("dispatcherServlet", new DispatcherServlet(dispatcherContext));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");
    }
}
