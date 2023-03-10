package com.hendisantika.springbootjwtdemo1.service;

import com.hendisantika.springbootjwtdemo1.exception.InvalidTokenRequestException;
import com.hendisantika.springbootjwtdemo1.exception.ResourceNotFoundException;
import com.hendisantika.springbootjwtdemo1.model.PasswordResetToken;
import com.hendisantika.springbootjwtdemo1.model.User;
import com.hendisantika.springbootjwtdemo1.model.payload.PasswordResetRequest;
import com.hendisantika.springbootjwtdemo1.repository.PasswordResetTokenRepository;
import com.hendisantika.springbootjwtdemo1.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

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

    /**
     * Creates and returns a new password token to which a user must be
     * associated and persists in the token repository.
     */
    public Optional<PasswordResetToken> createToken(User user) {
        PasswordResetToken token = createTokenWithUser(user);
        return Optional.of(passwordResetTokenRepository.save(token));
    }

    /**
     * Mark this password reset token as claimed (used by user to update password)
     * Since a user could have requested password multiple times, multiple tokens
     * would be generated. Hence, we need to invalidate all the existing password
     * reset tokens prior to changing the user password.
     */
    public PasswordResetToken claimToken(PasswordResetToken token) {
        User user = token.getUser();
        token.setClaimed(true);

        CollectionUtils.emptyIfNull(passwordResetTokenRepository.findActiveTokensForUser(user))
                .forEach(t -> t.setActive(false));

        return token;
    }

    /**
     * Verify whether the token provided has expired or not on the basis of the current
     * server time and/or throw error otherwise
     */
    void verifyExpiration(PasswordResetToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            throw new InvalidTokenRequestException("Password Reset Token", token.getToken(),
                    "Expired token. Please issue a new request");
        }
        if (!token.getActive()) {
            throw new InvalidTokenRequestException("Password Reset Token", token.getToken(),
                    "Token was marked inactive");
        }
    }

    /**
     * Match whether the token provided was actually generated by the user
     */
    void matchEmail(PasswordResetToken token, String requestEmail) {
        if (token.getUser().getEmail().compareToIgnoreCase(requestEmail) != 0) {
            throw new InvalidTokenRequestException("Password Reset Token", token.getToken(),
                    "Token is invalid for the given user " + requestEmail);
        }
    }

    PasswordResetToken createTokenWithUser(User user) {
        String tokenID = Util.generateRandomUuid();
        PasswordResetToken token = new PasswordResetToken();
        token.setToken(tokenID);
        token.setExpiryDate(Instant.now().plusMillis(expiration));
        token.setClaimed(false);
        token.setActive(true);
        token.setUser(user);
        return token;
    }
}
