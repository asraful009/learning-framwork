package com.cyber009.spring3security.entity.appuser;

import com.cyber009.spring3security.entity.BaseEntity;
import com.cyber009.spring3security.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "app_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Where(clause = "is_deleted = false")
@SQLDelete(sql = "UPDATE app_users SET is_deleted = true WHERE id=? and version=?")
public class AppUser extends BaseEntity {

    @Column(columnDefinition = "VARCHAR(256)", nullable = false, unique = true, updatable = false)
    private String userName;

    @Column(columnDefinition = "VARCHAR(4000)")
    private String password;

    @Builder.Default
    private Boolean isEnabled = Boolean.TRUE;
    @Builder.Default
    private Boolean isAccountNonExpired = Boolean.TRUE;
    @Builder.Default
    private Boolean isCredentialsNonExpired = Boolean.TRUE;
    @Builder.Default
    private Boolean isAccountNonLocked = Boolean.TRUE;

    @Column(columnDefinition = "VARCHAR(1024)")
    private String fullName;

    Collection<? extends GrantedAuthority> authorities;

    @Enumerated(EnumType.STRING)
    private Role role;


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
}
