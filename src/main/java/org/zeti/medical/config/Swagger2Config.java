package org.zeti.medical.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class Swagger2Config
{
    @Bean
    public Docket productApi()
    {
        Docket d = new Docket(DocumentationType.SWAGGER_2);
        d.select().apis(RequestHandlerSelectors.basePackage("org.zeti")).paths(regex("/.*")).build();
        return d;
    }
}