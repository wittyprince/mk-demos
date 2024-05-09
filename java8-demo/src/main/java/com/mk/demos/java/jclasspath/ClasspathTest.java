package com.mk.demos.java.jclasspath;

import com.mk.demos.java.introspector.UserInfo;

/**
 * ClasspathTest
 * ClasspathTest中引用了UserInfo，
 *      UserInfo位于不同包中,是在src/main/java/com/mk/demos/java/introspector/UserInfo.java中定义的。
 * 使用javac编译ClasspathTest.java时，需要指定classpath参数，指定UserInfo所在的目录。
 * 例如：
 * 当前位于src/main/java目录下, 命令如下：
 *  javac -classpath . com/mk/demos/java/jclasspath/ClasspathTest.java -encoding utf8
 * 如果位于src跟目录下，命令如下：
 *  javac -classpath src/main/java src/main/java/com/mk/demos/java/jclasspath/ClasspathTest.java
 * 如果是在src/main/java/com/mk/demos/java/jclasspath目录下，命令如下：
 *  javac -classpath ../../../../../../java/ ClasspathTest.java -encoding utf8
 * <br>
 *  这里UserInfo.java可以不用预先编译，因为javac会自动编译UserInfo.java。
 * @author WangChen
 * Created on 2024/5/9
 * @since 1.0
 */
public class ClasspathTest {
    private UserInfo userInfo;
}
