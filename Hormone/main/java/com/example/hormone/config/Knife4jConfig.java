package com.example.hormone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {
    @Bean
    public Docket defaultApi2(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .description("荷尔蒙API接口文档")
                        .termsOfServiceUrl("")
                        .contact(new Contact(
                                "Hormone后端",
                                "/",
                                "keyvhuang@hotmail.com"
                        ))
                        .version("1.0")
                        .build())
                .groupName("2.x版本")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.hormone"))
                .paths(PathSelectors.any())
                .build();
        return docket;

    }
}
