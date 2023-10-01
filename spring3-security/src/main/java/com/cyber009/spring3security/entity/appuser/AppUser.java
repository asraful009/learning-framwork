package com.cyber009.spring3security.entity.appuser;

import com.cyber009.spring3security.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "app_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE app_users SET is_deleted = true WHERE id=? and version=?")
public class AppUser extends BaseEntity {

    @Column(columnDefinition = "VARCHAR(256)", nullable = false, unique = true, updatable = false)
    private String userName;

    @Column(columnDefinition = "VARCHAR(4000)")
    private String password;

    @Column(columnDefinition = "VARCHAR(1024)")
    private String fullName;
}
