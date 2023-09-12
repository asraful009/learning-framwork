package com.cyber009.spring3.t0.entity;

import com.cyber009.spring3.t0.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.builder.EqualsExclude;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "instance_wise_permissions", indexes = {
        @Index(columnList = "instance_from"),
        @Index(columnList = "instance_id"),
        @Index(columnList = "access_policy"),
        @Index(columnList = "instance_from, instance_id", unique = true)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString(callSuper = true)
public class InstanceWisePermission extends BaseEntity {


    @Column(name = "instance_from", columnDefinition = "NVARCHAR2(2000)", updatable = false)
    @EqualsExclude
    private String instanceFrom;

    @Column(name = "instance_id", columnDefinition = "RAW(16)", updatable = false)
    private UUID instanceId;

    @Column(name = "access_policy", columnDefinition = "NVARCHAR2(32)")
    @EqualsExclude
    private String accessPolicy;

    @OneToMany(mappedBy = "instanceWisePermission", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InstanceWiseAppUserHasPermission> instanceWiseAppUserHasPermissions;
}


