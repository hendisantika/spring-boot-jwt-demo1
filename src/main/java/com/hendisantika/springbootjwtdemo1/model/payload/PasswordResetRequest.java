package com.hendisantika.springbootjwtdemo1.model.payload;

import com.hendisantika.springbootjwtdemo1.validation.annotation.MatchPassword;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/18/23
 * Time: 12:24
 * To change this template use File | Settings | File Templates.
 */
@MatchPassword
@Schema(name = "Password reset Request", description = "The password reset request payload")
@Data
public class PasswordResetRequest {

    @NotBlank(message = "The email for which the password needs to be reset can not be empty")
    @Schema(name = "The user email", required = true, allowableValues = "NonEmpty String")
    private String email;

    @NotBlank(message = "New password cannot be blank")
    @Schema(name = "New user password", required = true, allowableValues = "NonEmpty String")
    private String password;

    @NotBlank(message = "Confirm Password cannot be blank")
    @Schema(name = "Must match the new user password. Else exception will be thrown", required = true,
            allowableValues = "NonEmpty String matching the password")
    private String confirmPassword;

    @NotBlank(message = "Password reset token for the specified email has to be supplied")
    @Schema(name = "Reset token received in mail", required = true, allowableValues = "NonEmpty String")
    private String token;
}
