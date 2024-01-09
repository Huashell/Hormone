package com.example.hormone.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.Proxy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @Column(name = "username", length = 20, nullable = false)
    private String username;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @Column(name = "sex", length = 2, nullable = false)
    private String sex;

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "registerTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerTime;

    @Column(name = "status")
    private int status;

    // Getter and Setter methods
}
//@Entity
//@Table(name = "user")
////@Proxy(lazy = false)
//public class User implements UserDetails{
//
//
//    private static final long serialVersionUID = -974898607435110461L;
//
//    @Id
//    @Column(name = "userid")
//    @GeneratedValue
//    private Integer userid;
//
//    @Column(name = "username")
//    private String username;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "password")
//    private String password;
//
//    @Column(name = "role")
//    private Role role;
//
//    /*@Column(name = "account_non_expired" , columnDefinition = "bit default 1")
//    private boolean accountNonExpired;
//
//    @Column(name = "account_non_locked" , columnDefinition = "bit default 1")
//    private boolean accountNonLocked;
//
//    @Column(name = "credentials_non_expired" , columnDefinition = "bit default 1")
//    private boolean credentialsNonExpired;
//
//    @Column(name = "enabled" , columnDefinition = "bit default 1")
//    private boolean enabled;*/
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return getRole().getAuthorities();
//    }
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//
//
//}