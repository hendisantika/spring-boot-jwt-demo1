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
 * Time: 06:48
 * To change this template use File | Settings | File Templates.
 */
@Schema(name = "Update password Request", description = "The update password request payload")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordRequest {

    @NotBlank(message = "Old password must not be blank")
    @Schema(name = "Valid current user password", required = true, allowableValues = "NonEmpty String")
    private String oldPassword;

    @NotBlank(message = "New password must not be blank")
    @Schema(name = "Valid new password string", required = true, allowableValues = "NonEmpty String")
    private String newPassword;

}
