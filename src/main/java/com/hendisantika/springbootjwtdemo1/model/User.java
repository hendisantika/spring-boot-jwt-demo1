package com.hendisantika.springbootjwtdemo1.model;

import com.hendisantika.springbootjwtdemo1.model.audit.DateAudit;
import com.hendisantika.springbootjwtdemo1.validation.annotation.NullOrNotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jwt-demo1
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/19/23
 * Time: 06:50
 * To change this template use File | Settings | File Templates.
 */
@Entity(name = "USER")
@Getter
@Setter
public class User extends DateAudit {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", allocationSize = 1)
    private Long id;

    @NaturalId
    @Column(name = "EMAIL", unique = true)
    @NotBlank(message = "User email cannot be null")
    private String email;

    @Column(name = "USERNAME", unique = true)
    @NullOrNotBlank(message = "Username can not be blank")
    private String username;

    @Column(name = "PASSWORD")
    @NotNull(message = "Password cannot be null")
    private String password;

    @Column(name = "FIRST_NAME")
    @NullOrNotBlank(message = "First name can not be blank")
    private String firstName;

    @Column(name = "LAST_NAME")
    @NullOrNotBlank(message = "Last name can not be blank")
    private String lastName;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean active;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "USER_AUTHORITY", joinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")})
    private Set<Role> roles = new HashSet<>();

    @Column(name = "IS_EMAIL_VERIFIED", nullable = false)
    private Boolean isEmailVerified;

    public User() {
        super();
    }

    public User(User user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        email = user.getEmail();
        active = user.getActive();
        roles = user.getRoles();
        isEmailVerified = user.getEmailVerified();
    }

    public Boolean getEmailVerified() {
        return isEmailVerified;
    }

    public void addRole(Role role) {
        roles.add(role);
        role.getUserList().add(this);
    }

    public void addRoles(Set<Role> roles) {
        roles.forEach(this::addRole);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getUserList().remove(this);
    }

    public void setEmailVerified(Boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public void markVerificationConfirmed() {
        setEmailVerified(true);
    }
}
