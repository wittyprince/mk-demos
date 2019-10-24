package com.mk.demos.spring.boot;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;

@SpringBootApplication
//@ComponentScan(nameGenerator = SpringBootDemoApplication.SpringBeanNameGenerator.class)
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

//	public static class SpringBeanNameGenerator extends AnnotationBeanNameGenerator {
//		@Override
//		protected String buildDefaultBeanName(BeanDefinition definition) {
//			if (definition instanceof AnnotatedBeanDefinition) {
//				String beanName = determineBeanNameFromAnnotation((AnnotatedBeanDefinition) definition);
//				if (StringUtils.hasText(beanName)) {
//					// Explicit bean name found.
//					return beanName;
//				}
//			}
//			return definition.getBeanClassName();
//		}
//	}

}
