package com.hendisantika.springbootjwtdemo1.model.payload;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/18/23
 * Time: 12:30
 * To change this template use File | Settings | File Templates.
 */
@Data
public class JwtAuthenticationResponse {
    private String accessToken;

    private String refreshToken;

    private String tokenType;

    private Long expiryDuration;

    public JwtAuthenticationResponse(String accessToken, String refreshToken, Long expiryDuration) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiryDuration = expiryDuration;
        tokenType = "Bearer ";
    }
}
