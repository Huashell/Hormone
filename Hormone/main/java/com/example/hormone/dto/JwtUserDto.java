package com.example.hormone.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @param
 * @return
 **/
@Getter
@AllArgsConstructor
public class JwtUserDto implements UserDetails {

    private final UserLoginDto user;

    private final List<Long> dataScopes;

    private final List<AuthorityDto> authorities;

    public Set<String> getRoles() {
        return authorities.stream().map(AuthorityDto::getAuthority).collect(Collectors.toSet());
    }

    @Override
    @JSONField(serialize = false)
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    @JSONField(serialize = false)
    public String getUsername() {
        return user.getUsername();
    }

    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JSONField(serialize = false)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JSONField(serialize = false)
    public boolean isEnabled() {
        return user.isEnabled();
    }
}

