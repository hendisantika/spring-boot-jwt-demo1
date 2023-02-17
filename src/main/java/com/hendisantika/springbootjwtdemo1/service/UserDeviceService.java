package com.hendisantika.springbootjwtdemo1.service;

import com.hendisantika.springbootjwtdemo1.model.UserDevice;
import com.hendisantika.springbootjwtdemo1.model.token.RefreshToken;
import com.hendisantika.springbootjwtdemo1.repository.UserDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/18/23
 * Time: 06:31
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class UserDeviceService {
    private final UserDeviceRepository userDeviceRepository;

    /**
     * Find the user device info by user id
     */
    public Optional<UserDevice> findDeviceByUserId(Long userId, String deviceId) {
        return userDeviceRepository.findByUserIdAndDeviceId(userId, deviceId);
    }

    /**
     * Find the user device info by refresh token
     */
    public Optional<UserDevice> findByRefreshToken(RefreshToken refreshToken) {
        return userDeviceRepository.findByRefreshToken(refreshToken);
    }
}
