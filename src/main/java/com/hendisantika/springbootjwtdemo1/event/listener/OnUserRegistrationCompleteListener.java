package com.hendisantika.springbootjwtdemo1.event.listener;

import com.hendisantika.springbootjwtdemo1.event.OnUserRegistrationCompleteEvent;
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
 * Date: 2/14/23
 * Time: 06:28
 * To change this template use File | Settings | File Templates.
 */
@Component
public class OnUserRegistrationCompleteListener implements ApplicationListener<OnUserRegistrationCompleteEvent> {

    private static final Logger logger = Logger.getLogger(OnUserRegistrationCompleteListener.class);
    private final EmailVerificationTokenService emailVerificationTokenService;
    private final MailService mailService;

    @Autowired
    public OnUserRegistrationCompleteListener(EmailVerificationTokenService emailVerificationTokenService,
                                              MailService mailService) {
        this.emailVerificationTokenService = emailVerificationTokenService;
        this.mailService = mailService;
    }

    /**
     * As soon as a registration event is complete, invoke the email verification
     * asynchronously in an another thread pool
     */
    @Override
    @Async
    public void onApplicationEvent(OnUserRegistrationCompleteEvent onUserRegistrationCompleteEvent) {
        sendEmailVerification(onUserRegistrationCompleteEvent);
    }
}
