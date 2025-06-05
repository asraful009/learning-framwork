package com.cyber009.s3t2.entity;

import com.cyber009.s3t2.enums.EndPointMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permission_has_end_points")
public class PermissionHasEndPointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private EndPointMethod method;
    private String endPoint;
}
