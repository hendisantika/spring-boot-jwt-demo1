package com.hendisantika.springbootjwtdemo1.repository;

import com.hendisantika.springbootjwtdemo1.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/15/23
 * Time: 10:03
 * To change this template use File | Settings | File Templates.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
