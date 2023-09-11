package com.cyber009.spring3.t0.entity;

import com.cyber009.spring3.t0.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.builder.EqualsExclude;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Instance_wise_app_user_has_permissions", indexes = {
        @Index(columnList = "instance_wise_permission_id"),
        @Index(columnList = "app_user_id"),
        @Index(columnList = "method"),
        @Index(columnList = "sorting_order ASC"),
        @Index(columnList = "instance_wise_permission_id, app_user_id"),
        @Index(columnList = "instance_wise_permission_id, app_user_id, method", unique = true),

})
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@SuperBuilder
@ToString(callSuper = true)
public class InstanceWiseAppUserHasPermission extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "instance_wise_permission_id")
    @EqualsExclude
    private InstanceWisePermission instanceWisePermission;

    @Column(name = "app_user_id", columnDefinition = "RAW(16)", updatable = false, nullable = false)
    @EqualsExclude
    private UUID appUserId;

    @Column(name = "method", columnDefinition = "NVARCHAR2(32)")
    private String method;

    @Column(name = "sorting_order", columnDefinition = "NUMBER(10) DEFAULT 0")
    private Integer sortingOrder;
}


