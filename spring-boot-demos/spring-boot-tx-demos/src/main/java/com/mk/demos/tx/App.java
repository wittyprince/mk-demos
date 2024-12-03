package com.mk.demos.tx;

import com.mk.demos.tx.model.User;
import com.mk.demos.tx.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 */
@Mapper
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        UserService userService = context.getBean(UserService.class);

        User user = new User();
        user.setName("wc");
        user.setAge(18);
//        userService.save(user);
//        userService.testTransactional(user);
        userService.testTransactionalWithTransactionalAnnotation(user);

    }
}
