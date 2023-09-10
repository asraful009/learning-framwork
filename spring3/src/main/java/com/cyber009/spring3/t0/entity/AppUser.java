package com.cyber009.spring3.t0.entity;

import com.cyber009.spring3.t0.common.entity.Address;
import com.cyber009.spring3.t0.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "app_users", indexes = {
        @Index(columnList = "userName")
})
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@SuperBuilder
@ToString(callSuper = true)
public class AppUser extends BaseEntity {

    @Column(columnDefinition = "NVARCHAR2(1024)", nullable = false)
    private String userName;

    @Column(columnDefinition = "NVARCHAR2(1024)")
    private String fullName;

    @Column(columnDefinition = "VARCHAR2(4000)")
    private String salt;

    @Column(columnDefinition = "VARCHAR2(4000)")
    private String hashPassword;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
