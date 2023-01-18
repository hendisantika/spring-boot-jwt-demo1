package com.hendisantika.springbootjwtdemo1.model.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/19/23
 * Time: 06:43
 * To change this template use File | Settings | File Templates.
 */
@Tag(name = "Logout request", description = "The logout request payload")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogOutRequest {

    @Valid
    @NotNull(message = "Device info cannot be null")
    @Schema(name = "Device info", required = true, type = "object", allowableValues = "A valid " +
            "deviceInfo object", accessMode = Schema.AccessMode.READ_ONLY)
    private DeviceInfo deviceInfo;
}
