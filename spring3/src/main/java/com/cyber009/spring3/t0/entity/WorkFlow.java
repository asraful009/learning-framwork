package com.cyber009.spring3.t0.entity;


import com.cyber009.spring3.t0.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "workflows", indexes = {
        @Index(columnList = "title")
})
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString(callSuper = true)
public class WorkFlow extends BaseEntity {

    @Column(columnDefinition = "NVARCHAR2(2000)", nullable = false)
    private String title;

}
