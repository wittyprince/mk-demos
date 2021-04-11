package com.mk.demos.spring.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * xml 方式 初始化 web application context
 *
 * https://www.vojtechruzicka.com/spring-get-rid-of-web-xml/
 *
 * @author WangChen
 * Created on 2021/4/11 17:01
 * @since 1.0
 */
public class XmlWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        // 1. 配置 root ApplicationContext
        XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
        // 关于路径名称，参考 com.mk.demos.spring.ioc.container.xml.ClassPathXmlApplicationContextTest
        // 另外，这里需注意：对于ServletContext而言，其默认加载路径为webapp下，而不是java工程的resources下
        String location = "WEB-INF/xml-root-context.xml";
        rootContext.setConfigLocation(location);
        container.addListener(new ContextLoaderListener(rootContext));

        // 2. 配置 web ApplicationContext
        XmlWebApplicationContext dispatcherContext = new XmlWebApplicationContext();
        dispatcherContext.setConfigLocation("WEB-INF/xml-web-context.xml");

        // 3. 配置 DispatcherServlet
        ServletRegistration.Dynamic dispatcherServlet = container.addServlet("dispatcherServlet", new DispatcherServlet(dispatcherContext));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");

        // 4. 注意：
        // 4.1 当使用maven-war-plugin3.1以前的版本打war包时，
        //      如果没有web.xml文件，会报缺少web.xml文件异常
        //      需要配置failOnMissingWebXml = false 予以解决
        // 4.2 WebApplicationInitializer接口不能指定web.xml文件中的welcome-file-list，需通过其他方式解决
        //      参考 https://stackoverflow.com/questions/30972676/how-to-specify-welcome-file-list-in-webapplicationinitializer-onstartup
        //      4.2.1 方式一："/" 路径映射(不推荐)
        //      @Controller
        //      public class UserController {
        //          @RequestMapping(value = { "/" })
        //          public String homePage() {
        //              return "home";
        //          }
        //      }
        //      4.2.2 方式二：
    }
}
