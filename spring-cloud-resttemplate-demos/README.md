服务方由spring-cloud-openfeign-provider1-demos提供

RestTemplate 不用基于Spring Cloud, 只需要基于Spring Web即可

参考：
https://www.cnblogs.com/h--d/p/12609753.html
https://juejin.cn/post/6844903842065154061


Spring框架提供的RestTemplate类可用于在应用中调用rest服务，它简化了与http服务的通信方式，统一了RESTful的标准，封装了http链接， 我们只需要传入url及返回值类型即可。相较于之前常用的HttpClient，RestTemplate是一种更优雅的调用RESTful服务的方式。

在Spring应用程序中访问第三方REST服务与使用Spring RestTemplate类有关。RestTemplate类的设计原则与许多其他Spring *模板类(例如JdbcTemplate、JmsTemplate)相同，为执行复杂任务提供了一种具有默认行为的简化方法。

RestTemplate默认依赖JDK提供http连接的能力（HttpURLConnection），如果有需要的话也可以通过setRequestFactory方法替换为例如 Apache HttpComponents、Netty或OkHttp等其它HTTP library。
