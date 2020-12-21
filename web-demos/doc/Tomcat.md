#### Tomcat服务器 = Web服务器 + Servlet/JSP容器（Web容器）
- Web服务器的作用是接收客户端的请求，给客户端作出响应。
- JSP/Servlet容器的基本功能是把动态资源转换成静态资源
```
但是很明显，服务器不止静态资源呀，
所以客户端发起请求后，如果是动态资源，
Web服务器不可能直接把它响应回去（比如JSP），
因为浏览器只认识静态资源。
所以对于JavaWeb程序而言，还需要JSP/Servlet容器，
我们JavaWeb工程师需要使用Web服务器和JSP/Servlet容器，
而通常这两者会集于一身，比如Tomcat。
```

