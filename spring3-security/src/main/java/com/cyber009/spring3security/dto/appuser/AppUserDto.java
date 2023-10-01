package com.cyber009.spring3security.dto.appuser;

import com.cyber009.spring3security.dto.BaseDto;
import com.cyber009.spring3security.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
@ToString(callSuper = true)
public class AppUserDto extends BaseDto {
    private String email;
    private Boolean isEnabled = Boolean.TRUE;
    private Boolean isAccountNonExpired = Boolean.TRUE;
    private Boolean isCredentialsNonExpired = Boolean.TRUE;
    private Boolean isAccountNonLocked = Boolean.TRUE;
    private String fullName;
    Collection<? extends GrantedAuthority> authorities;
    private Role role;
}
