package com.mk.demos.agent;

// mvn clean package 打包（注意pom.xml中配置了maven-assembly-plugin）
// 生成两个jar包： agent-demo.jar 和 agent-demo-jar-with-dependencies.jar
//
// 动态代理的两种验证方式：
// 第一种方式：执行agent-demo.jar, 由于该jar包内没有把dependency依赖打到包内，需使用-Xbootclasspath/a:方式来配合
// application应用程序类启动命令如下：
// java -Xbootclasspath/a:D:/Gitspace/maven-repository/org/javassist/javassist/3.29.0-GA/javassist-3.29.0-GA.jar -jar target/agent-demo.jar StartMyAtmApplication 10000 2 3
// 代理类启动命令如下:
// java -Xbootclasspath/a:D:/Gitspace/maven-repository/com/sun/tools/attach/8/attach-8.jar -jar target/agent-demo.jar LoadAgent target/agent-demo.jar
//
// 第二种方式：执行agent-demo-jar-with-dependencies.jar, 该jar包内把dependency依赖打到包内，直接执行即可
// application类启动命令如下：
// java -jar target/agent-demo-jar-with-dependencies.jar StartMyAtmApplication 100000 2 3
// 代理类启动命令如下:
// java -jar target/agent-demo-jar-with-dependencies.jar LoadAgent target/agent-demo-jar-with-dependencies.jar
//
// 如上两种方式都可以验证动态代理的效果
//
//
// 也可以使用静态代理的验证：
// 启动命令如下：
// java -javaagent:target/agent-demo-jar-with-dependencies.jar -jar target/agent-demo-jar-with-dependencies.jar StartMyAtmApplication 1000 2 3
//
//
//
//
//
//
//
//
//
//
//
// 执行 java -javaagent:agent-demo.jar -jar agent-demo-jar-with-dependencies.jar StartMyAtmApplication 1000 1000 1000
//