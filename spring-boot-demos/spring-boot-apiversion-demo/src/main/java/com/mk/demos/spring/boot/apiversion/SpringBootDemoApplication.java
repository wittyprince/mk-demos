package com.mk.demos.spring.boot.apiversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
