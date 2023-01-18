package com.hendisantika.springbootjwtdemo1.model.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/19/23
 * Time: 06:45
 * To change this template use File | Settings | File Templates.
 */
@Schema(name = "Password reset link request", description = "The password reset link payload")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResetLinkRequest {
    @NotBlank(message = "Email cannot be blank")
    @Schema(name = "User registered email", required = true, allowableValues = "NonEmpty String")
    private String email;
}
