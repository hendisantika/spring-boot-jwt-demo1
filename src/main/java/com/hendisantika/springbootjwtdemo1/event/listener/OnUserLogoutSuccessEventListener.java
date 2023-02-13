package com.hendisantika.springbootjwtdemo1.event.listener;

import com.hendisantika.springbootjwtdemo1.cache.LoggedOutJwtTokenCache;
import com.hendisantika.springbootjwtdemo1.event.OnUserLogoutSuccessEvent;
import com.hendisantika.springbootjwtdemo1.model.payload.DeviceInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/14/23
 * Time: 06:27
 * To change this template use File | Settings | File Templates.
 */
@Component
public class OnUserLogoutSuccessEventListener implements ApplicationListener<OnUserLogoutSuccessEvent> {

    private static final Logger logger = Logger.getLogger(OnUserLogoutSuccessEventListener.class);
    private final LoggedOutJwtTokenCache tokenCache;

    @Autowired
    public OnUserLogoutSuccessEventListener(LoggedOutJwtTokenCache tokenCache) {
        this.tokenCache = tokenCache;
    }

    public void onApplicationEvent(OnUserLogoutSuccessEvent event) {
        if (null != event) {
            DeviceInfo deviceInfo = event.getLogOutRequest().getDeviceInfo();
            logger.info(String.format("Log out success event received for user [%s] for device [%s]",
                    event.getUserEmail(), deviceInfo));
            tokenCache.markLogoutEventForToken(event);
        }
    }
}
