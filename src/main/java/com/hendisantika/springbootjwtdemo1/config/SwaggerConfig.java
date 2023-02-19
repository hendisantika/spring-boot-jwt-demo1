package com.hendisantika.springbootjwtdemo1.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/19/23
 * Time: 20:02
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("com.hendisantika.springbootjwtdemo1")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public OpenAPI metaInfo() {
        return new OpenAPI()
                .info(new Info().title("Backend API For the Auth/User Service")
                        .description("Backend API For the Auth/User Service")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Backend API Wiki Documentation")
                        .url("https://Backend API.wiki.github.org/docs"));
    }
}
