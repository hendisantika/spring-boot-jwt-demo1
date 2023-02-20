package com.hendisantika.springbootjwtdemo1.controller;

import com.hendisantika.springbootjwtdemo1.security.JwtTokenProvider;
import com.hendisantika.springbootjwtdemo1.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/21/23
 * Time: 04:05
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "Authorization Rest API", description = "Defines endpoints that can be hit only when the user is not " +
        "logged in. It's not secured by default.")

public class AuthController {

    private static final Logger logger = Logger.getLogger(AuthController.class);
    private final AuthService authService;
    private final JwtTokenProvider tokenProvider;
    private final ApplicationEventPublisher applicationEventPublisher;
}
