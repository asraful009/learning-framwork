package com.cyber009.spring3.t0.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "offices")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@SuperBuilder
@ToString(callSuper = true)
public class Office extends BaseEntity {

    @Column(columnDefinition = "NVARCHAR2(1024)")
    private String name;


//    private List<Office> officeList;
}
