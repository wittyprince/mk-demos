#### Java中一些常用名词缩写解释
- J2SE
```
Java 2 Standard Edtion //Java 2 标准版
核心功能。 
它定义了从Java编程语言的基本类型和对象到用于网络，
安全性，数据库访问，图形用户界面（GUI）开发和XML解析的高级类的所有内容。
还包括虚拟机，开发工具，部署技术以及Java技术应用程序中常用的其他类库和工具包。
```
- Java EE, J2EE    
```
 Java Platform Enterprise Edition    //平台企业版
 JavaEE包含一系列技术标准
``` 
- J2ME    
```
Java 2 Micro Edition
是Java 2的一个组成部分，它与J2SE、J2EE并称.J2ME是一种高度优化的Java运行环境，主要针对消费类电子设备的，例如蜂窝电话和可视电话、数字机顶盒、汽车导航系统等等.
```

-JavaFX
```
JavaFX的推出是为了取代Swing,作为JavaSe中标准的GUI lib
很少有人使用
```
- JMS    
```
Java Message Service     //java消息服务
是访问企业消息系统的标准API,它便于消息系统中的Java应用程序进行消息交换,
并且通过提供标准的产生、发送、接收消息的接口简化企业应用的开发。
 ```

- JMX
``` 
Java Management Extensions    //Java管理扩展
即Java管理扩展,是一个为应用程序、设备、系统等植入管理功能的框架。
JMX可以跨越一系列异构操作系统平台、系统体系结构和网络传输协议，灵活的开发无缝集成的系统、网络和服务管理应用。
```
- DAO    
```
Data Access Object     //数据访问接口
数据访问：顾名思义就是与数据库打交道。夹在业务逻辑与数据库资源中间。
```
- JDBC    
```
Java Data Base Connectivity    //java数据库连接
是一种用于执行SQL语句的Java API，可以为多种关系数据库提供统一访问，
它由一组用Java语言编写的类和接口组成。
```
- JNDI    
```
Java Naming and Directory Interface    //Java命名和目录接口
是一个应用程序设计的API，为开发人员提供了查找和访问各种命名和目录服务的通用、统一的接口，
类似JDBC都是构建在抽象层上。
```

- EAO
```
Entity Access Object
EAO是基于DAO的，它分离了数据层、持久层、业务层和表达式。把实体作为对象进行传递。EAO与DAO在本质上是相同的，只是传输的对象是不同的。EAO接口实现类中用Entity传递。
```

- DTO    
```
Data Transfer Object    //数据传输对象
用于数据的远程调用方面.
```

- JSTL    
```
JSP Standard Tag Library   //JSP标准标签库
是一个不断完善的开放源代码的JSP标签库.主要是简化JSP和WEB应用程序.
```

- EJB
```
Enterprise JavaBean
是J2EE的一部分，定义了一个用于开发基于组件的企业多重应用程序的标准。
其特点包括网络服务支持和核心开发工具(SDK)。
```

- JTA
```
Java Transaction API
为 J2EE 平台提供了分布式事务服务。
要用 JTA 进行事务界定，应用程序要调用 javax.transaction.UserTransaction 接口中的方法。
```

- JDK    
```
Java Development Kit
是Sun Microsystems针对Java开发员的产品。
自从Java推出以来，JDK已经成为使用最广泛的Java SDK。JDK 是整个Java的核心，包括了Java运行环境，Java工具和Java基础的类库。
```

- JRE    
```
Java Runtime Kit     //java运行环境
运行JAVA程序所必须的环境的集合，包含JVM标准实现及Java核心类库。
它不包含开发工具--编译器、调试器和其它工具。
```

- JSP
```
Java Server Pages
JSP页面由HTML代码和嵌入其中的Java代码所组成。
服务器在页面被客户端所请求以后对这些Java代码进行处理，
然后将生成的HTML页面返回给客户端的浏览器。
```

- JTS    
```
Java Transaction Service
JTS是CORBA OTS事务监控的基本的实现。
JTS规定了事务管理器的实现方式。
该事务管理器是在高层支持Java Transaction API (JTA)规范，
并且在较底层实现OMG OTS specification的Java映像。
JTS事务管理器为应用服务器、资源管理器、独立的应用以及通信资源管理器提供了事务服务。
```

- JAX-WS
```
JAX-WS全称是 Java API for XML-Based Web Services.
```

- JAX-RS
```
JAX-RS 全称是 Java API for RESTful Web Services.
```