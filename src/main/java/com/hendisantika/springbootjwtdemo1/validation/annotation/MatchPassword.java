package com.hendisantika.springbootjwtdemo1.validation.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/18/23
 * Time: 12:22
 * To change this template use File | Settings | File Templates.
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MatchPasswordValidator.class)
@Documented
public @interface MatchPassword {
    String message() default "The new passwords must match";

    Class<?>[] groups() default {};

    boolean allowNull() default false;

    Class<? extends Payload>[] payload() default {};
}
