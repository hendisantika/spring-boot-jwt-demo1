package com.hendisantika.springbootjwtdemo1.service;

import com.hendisantika.springbootjwtdemo1.exception.ResourceNotFoundException;
import com.hendisantika.springbootjwtdemo1.model.PasswordResetToken;
import com.hendisantika.springbootjwtdemo1.model.payload.PasswordResetRequest;
import com.hendisantika.springbootjwtdemo1.repository.PasswordResetTokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/17/23
 * Time: 06:21
 * To change this template use File | Settings | File Templates.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PasswordResetTokenService {

    private final PasswordResetTokenRepository passwordResetTokenRepository;

    @Value("${app.token.password.reset.duration}")
    private Long expiration;

    /**
     * Finds a token in the database given its naturalId or throw an exception.
     * The reset token must match the email for the user and cannot be used again
     */
    public PasswordResetToken getValidToken(PasswordResetRequest request) {
        String tokenID = request.getToken();
        PasswordResetToken token = passwordResetTokenRepository.findByToken(tokenID)
                .orElseThrow(() -> new ResourceNotFoundException("Password Reset Token", "Token Id", tokenID));

        matchEmail(token, request.getEmail());
        verifyExpiration(token);
        return token;
    }
}
