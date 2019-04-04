##### maven构建为web项目
1. src/main/ 目录下新建webapp目录
2. 在webapp目录下新建WEB-INF文件夹, 在WEB-INF目录下新建web.xml文件(此步骤在servlet3.1以上可省略,是由于web.xml的作用是配置servlet-class, servlet-name, servlet-mapping, 可由@WebServlet标签替代)
3. 在webapp目录下新建index.jsp文件
4. 修改pom.xml文件中的<packaging>为war
5. 执行mvn clean package 构建war包
6. 在run --> Edit Configurations --> 左上角"+"(加号)添加 Local Tomcat Server --> 在deployment中选择war部署即可

参考:    
https://dzone.com/articles/how-to-create-a-web-project-using-maven-in-eclipse-1
