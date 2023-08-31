package com.cyber009.spring3.t0.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "addresses", indexes = {
        @Index(columnList = "mobile"),
        @Index(columnList = "email"),
        @Index(columnList = "addressLine"),
        @Index(columnList = "city"),
        @Index(columnList = "country")
})
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString(callSuper = true)
public class Address extends BaseEntity {

    @Column(columnDefinition = "NVARCHAR2(2000)")
    private String mobile;

    @Column(columnDefinition = "NVARCHAR2(2000)")
    private String email;

    @Column(columnDefinition = "NVARCHAR2(2000)")
    private String addressLine;

    @Column(columnDefinition = "NVARCHAR2(2000)")
    private String city;

    @Column(columnDefinition = "NVARCHAR2(2000)")
    private String country;

    @Column(columnDefinition = "NVARCHAR2(2000)")
    private String postalCode;
}
