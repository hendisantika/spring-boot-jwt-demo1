package com.hendisantika.springbootjwtdemo1.model.payload;

import com.hendisantika.springbootjwtdemo1.validation.annotation.NullOrNotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/19/23
 * Time: 06:46
 * To change this template use File | Settings | File Templates.
 */
@Schema(name = "Registration Request", description = "The registration request payload")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {

    @NullOrNotBlank(message = "Registration username can be null but not blank")
    @Schema(name = "A valid username", allowableValues = "NonEmpty String")
    private String username;

    @NullOrNotBlank(message = "Registration email can be null but not blank")
    @Schema(name = "A valid email", required = true, allowableValues = "NonEmpty String")
    private String email;

    @NotNull(message = "Registration password cannot be null")
    @Schema(name = "A valid password string", required = true, allowableValues = "NonEmpty String")
    private String password;

    @NotNull(message = "Specify whether the user has to be registered as an admin or not")
    @Schema(name = "Flag denoting whether the user is an admin or not", required = true,
            type = "boolean", allowableValues = "true, false")
    private Boolean registerAsAdmin;

}
