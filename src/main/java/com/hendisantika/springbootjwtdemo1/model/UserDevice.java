package com.hendisantika.springbootjwtdemo1.model;

import com.hendisantika.springbootjwtdemo1.model.audit.DateAudit;
import com.hendisantika.springbootjwtdemo1.model.token.RefreshToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/19/23
 * Time: 06:54
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "USER_DEVICE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDevice extends DateAudit {

    @Id
    @Column(name = "USER_DEVICE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_device_seq")
    @SequenceGenerator(name = "user_device_seq", allocationSize = 1)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "DEVICE_TYPE")
    @Enumerated(value = EnumType.STRING)
    private DeviceType deviceType;

    @Column(name = "NOTIFICATION_TOKEN")
    private String notificationToken;

    @Column(name = "DEVICE_ID", nullable = false)
    private String deviceId;

    @OneToOne(optional = false, mappedBy = "userDevice")
    private RefreshToken refreshToken;

    @Column(name = "IS_REFRESH_ACTIVE")
    private Boolean isRefreshActive;
}
