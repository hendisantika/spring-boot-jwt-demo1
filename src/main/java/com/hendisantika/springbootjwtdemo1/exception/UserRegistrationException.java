package com.hendisantika.springbootjwtdemo1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/29/23
 * Time: 07:17
 * To change this template use File | Settings | File Templates.
 */
@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class UserRegistrationException extends RuntimeException {

    private final String user;
    private final String message;

    public UserRegistrationException(String user, String message) {
        super(String.format("Failed to register User[%s] : '%s'", user, message));
        this.user = user;
        this.message = message;
    }
}
