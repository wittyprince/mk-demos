#### J2EE
JAVA EE, Java 2 Platform, Enterprise Edition 企业版本
https://www.zhihu.com/question/52002845
```
The Java EE platform is built on top of the Java SE platform. The Java EE platform provides an API and runtime environment for developing and running large-scale, multi-tiered, scalable, reliable, and secure network applications.
Java EE平台建立在Java SE平台之上。 
Java EE平台提供了一个API和运行时环境，用于开发和运行大规模，
多层，可伸缩，可靠和安全的网络应用程序。
```

JavaEE的13个规范(不止)    
- JDBC（java Database Connectivity）数据库连接
- JNDI(Java Name and Directory Interface)命名雨目录接口
- EJB（Enterprise JavaBean）企业级JavaBean
- RMI（RemoteMethod Invoke）
- Java IDL（接口定义语言）/CORBA6、JSP(Java Server Pages)
- Java Servlet (servlet api)
- XML（Extensible Markup Language）    
`JAXM: Java API for XML Message`
`JAXP: Java API for XML Processing`
`JAXR: Java API for XML Registries`
`JAX-WS: Java API for XML-Based Web Services`
- JMS（Java Message Service）消息服务
- JTA（Java Transaction Architecture）
- JTS（Java Transaction Service）
- JavaMail
- JAF（JavaBeans Activation Framework）

下面是一些实现了这些规范的框架   
**Web层**
- 关注于为客户端生成各种格式内容的视图模块：JSP JSTL EL JSF
- 关注于Web实时交互的模块：WebSocket Java API——SpringBoot框架
- 关注于Web实时交互的模块：WebSocket Java API——SpringBoot框架
- 关注于交互数据规范的模块：JSON-P JAXB
- 关注于Web请求和响应的模块：Servlet——SpringBoot框架


- 关注于与数据库交互的模块：JDBC——Hibernate框架、SpringData Jpa框架
- 关注于与数据库交互的模块：JDBC——Hibernate框架、SpringData Jpa框架
- 关注于Java信息服务的模块：JMS——ActiveMq消息中间件
- 关注于Mail服务的模块：JavaMail API

- 关注于上下文与依赖注入的模块：CDI——Spring框架
- 关注于整合安全的模块：JACC JASP JAAS
