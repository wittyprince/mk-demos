package com.mk.demos.spring.ioc.container.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mk.demos.spring.model.user.Profile;
import com.mk.demos.spring.model.user.User;

/**
 * xml 方式 配置 ApplicationContext
 *
 * @author WangChen
 * Created on 2021/4/9 14:56
 * @since 1.0
 */
public class ClassPathXmlApplicationContextTest {

    public static void main(String [] args){
        // 方式一：相对路径 (推荐)
        String configLocation = "META-INF/xml-context.xml";
        // 方式二：绝对路径
        // String configLocation = "classpath:/META-INF/xml-context.xml";

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);

        User user = applicationContext.getBean("user", User.class);

        System.out.println(user);

        // name 属性可以使用逗号, 分号; 空格 分隔，定义不同的别名
        User dUser = applicationContext.getBean("dUser", User.class);
        System.out.println("dUser: " + dUser);

        // 使用alias命名别名
        User myUser = applicationContext.getBean("myUser", User.class);
        System.out.println("myUser: " + myUser);

        // singleton类型的bean A 引用prototype类型的bean B 作为property属性时，
        // 每次获取 A 时，其属性 B 并不会每次都重新生成，
        // 如下 pUser1.getProfile().hashCode() == pUser2.getProfile().hashCode()
        // 这是因为对于singleton类型的bean，spring容器在instantiate实例化时，便指定好了依赖关系
        // 可以使用method injection方式来实现每次都动态实例化bean B
        User pUser1 = applicationContext.getBean("pUser", User.class);
        System.out.println("pUser1:" + pUser1.getProfile().hashCode());
        User pUser2 = applicationContext.getBean("pUser", User.class);
        System.out.println("pUser2:" + pUser2.getProfile().hashCode());

        // 对于prototype类型的bean，每次获取该bean的实例时，都会生成新的instantiation实例
        Profile profile1 = applicationContext.getBean(Profile.class);
        System.out.println("profile1:" + profile1.hashCode());
        Profile profile2 = applicationContext.getBean(Profile.class);
        System.out.println("profile2:" + profile2.hashCode());
    }
}
