package com.OB_Spring_789_new.ObSpring789.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();

    }

    public ApiInfo apiDetails(){

        return new ApiInfo("Spring Boot Book API REST",
                "Library Api rest docs",
                "1.0",
                "http://www.google.com",
                new Contact("Alan", "http://www.google.com", "alan@example.com"),
                "MIT",
                "http://www.google.com",
                Collections.emptyList());
    }


}
