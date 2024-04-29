package com.mk.demos.bean.validation3;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import java.util.Set;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        User user = new User();
//        user.setName("wc");
        user.setWorking(true);
        user.setAboutMe("Its all about me!");
        user.setAge(50);

        ValidatorFactory //factory = Validation.buildDefaultValidatorFactory();
        factory = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.err.println(violation.getMessage());
            // Name cannot be null
        }


    }
}
