package com.hendisantika.springbootjwtdemo1.repository;

import com.hendisantika.springbootjwtdemo1.model.UserDevice;
import com.hendisantika.springbootjwtdemo1.model.token.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/15/23
 * Time: 10:04
 * To change this template use File | Settings | File Templates.
 */
public interface UserDeviceRepository extends JpaRepository<UserDevice, Long> {

    @Override
    Optional<UserDevice> findById(Long id);

    Optional<UserDevice> findByRefreshToken(RefreshToken refreshToken);

    Optional<UserDevice> findByUserIdAndDeviceId(Long userId, String userDeviceId);
}
