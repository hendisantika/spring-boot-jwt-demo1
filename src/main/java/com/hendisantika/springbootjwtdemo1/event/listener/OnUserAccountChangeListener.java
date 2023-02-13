package com.hendisantika.springbootjwtdemo1.event.listener;

import com.hendisantika.springbootjwtdemo1.event.OnUserAccountChangeEvent;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/13/23
 * Time: 09:28
 * To change this template use File | Settings | File Templates.
 */
@Component
public class OnUserAccountChangeListener implements ApplicationListener<OnUserAccountChangeEvent> {

    private static final Logger logger = Logger.getLogger(OnUserAccountChangeListener.class);
    private final MailService mailService;

    @Autowired
    public OnUserAccountChangeListener(MailService mailService) {
        this.mailService = mailService;
    }

    /**
     * As soon as a registration event is complete, invoke the email verification
     * asynchronously in an another thread pool
     */
    @Override
    @Async
    public void onApplicationEvent(OnUserAccountChangeEvent onUserAccountChangeEvent) {
        sendAccountChangeEmail(onUserAccountChangeEvent);
    }
}
