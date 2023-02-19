package com.hendisantika.springbootjwtdemo1.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/19/23
 * Time: 20:06
 * To change this template use File | Settings | File Templates.
 */
@Profile("dev")
@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityDevConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = Logger.getLogger(WebSecurityDevConfig.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("Loaded inside a dev only");
        http.authorizeRequests()
                .anyRequest().permitAll();
    }
}
