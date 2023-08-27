package com.cyber009.spring3.t0.entity;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office parentOffice;

    @OneToMany(mappedBy = "parentOffice")
    private List<Office> childOffices;
}
