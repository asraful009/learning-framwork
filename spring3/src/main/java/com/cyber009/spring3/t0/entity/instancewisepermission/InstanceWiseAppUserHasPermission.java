package com.cyber009.spring3.t0.entity.instancewisepermission;

import com.cyber009.spring3.t0.common.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.hibernate.annotations.SQLDelete;

import java.util.UUID;

@Entity
@Table(name = "instance_wise_app_user_has_permissions", indexes = {
        @Index(columnList = "instance_wise_permission_id"),
        @Index(columnList = "app_user_id"),
        @Index(columnList = "method"),
        @Index(columnList = "sorting_order ASC"),
        @Index(columnList = "instance_wise_permission_id, app_user_id"),
        @Index(columnList = "instance_wise_permission_id, app_user_id, method"),

})
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString(callSuper = true)
@SQLDelete(sql = "UPDATE instance_wise_app_user_has_permissions SET deleted = true WHERE id=? and version=?")
public class InstanceWiseAppUserHasPermission extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "instance_wise_permission_id")
    @EqualsExclude
    @ToString.Exclude
    @JsonIgnore
    private InstanceWisePermission instanceWisePermission;

    @Column(name = "app_user_id", columnDefinition = "RAW(16)", updatable = false, nullable = false)
    @EqualsExclude
    private UUID appUserId;

    @Column(name = "method", columnDefinition = "NVARCHAR2(32)")
    private String method;

    @Column(name = "sorting_order", columnDefinition = "NUMBER(10) DEFAULT 0")
    @EqualsExclude
    private Integer sortingOrder;
}


