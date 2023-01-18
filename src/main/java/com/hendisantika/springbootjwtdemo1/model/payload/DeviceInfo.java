package com.hendisantika.springbootjwtdemo1.model.payload;

import com.hendisantika.springbootjwtdemo1.model.token.DeviceType;
import com.hendisantika.springbootjwtdemo1.validation.annotation.NullOrNotBlank;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/18/23
 * Time: 12:28
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceInfo {
    @NotBlank(message = "Device id cannot be blank")
    @Schema(name = "Device Id", required = true, type = "string", allowableValues = "Non empty string")
    private String deviceId;

    @NotNull(message = "Device type cannot be null")
    @Schema(name = "Device type Android/iOS", required = true, type = "string", allowableValues =
            "DEVICE_TYPE_ANDROID, DEVICE_TYPE_IOS")
    private DeviceType deviceType;

    @NullOrNotBlank(message = "Device notification token can be null but not blank")
    @Schema(name = "Device notification id", type = "string", allowableValues = "Non empty string")
    private String notificationToken;
}
