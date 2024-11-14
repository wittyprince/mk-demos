package com.mk.demos.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;

/**
 * Swagger3Config
 *
 * @author WangChen
 * Created on 2023/5/18
 * @since 1.0
 */
@Configuration
public class Swagger3Config {

    @Bean
    public Docket petApi() {
        ApiInfo apiInfo = new ApiInfoBuilder().title("Spring Boot swagger3 整合")
                .contact(new Contact("IT实验室", "https://itlab1024.com", "itlab1024@163.com"))
                .description("Spring Boot 版本2.7、Swagger3 整合")
                .license("Apache 2.0")
                .licenseUrl("https://raw.githubusercontent.com/itlab1024/spring-boot-swagger3-tutorial/main/LICENSE")
                .version("1.0")
                .termsOfServiceUrl("服务条款URL")
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.mk.demos"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .enableUrlTemplating(true);
    }
}
