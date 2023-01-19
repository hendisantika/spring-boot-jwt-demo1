package com.hendisantika.springbootjwtdemo1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/19/23
 * Time: 07:05
 * To change this template use File | Settings | File Templates.
 */
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class MailSendException extends RuntimeException {

    private final String recipientAddress;
    private final String message;

    public MailSendException(String recipientAddress, String message) {
        super(String.format("Error sending [%s] for user [%s]", message, recipientAddress));
        this.recipientAddress = recipientAddress;
        this.message = message;
    }
}
