##### maven 构建Servlet3.0 web项目(无web.xml文件)
1. 实现WebApplicationInitializer接口，重写onStartup方法
2. 在onStartup方法中
    1. 配置 root ApplicationContext
       1. 配置rootContext.setConfigLocation(location);
       2. 注册监听器container.addListener(new ContextLoaderListener(rootContext));
    2. 配置 web ApplicationContext
       1. 配置dispatcherContext.setConfigLocation("WEB-INF/xml-web-context.xml");
    3. 配置 DispatcherServlet
    ```
    ServletRegistration.Dynamic dispatcherServlet = container.addServlet("dispatcherServlet", new DispatcherServlet(dispatcherContext));
    dispatcherServlet.setLoadOnStartup(1);
    dispatcherServlet.addMapping("/");
    ```
   