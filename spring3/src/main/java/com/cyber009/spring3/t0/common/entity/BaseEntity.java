package com.cyber009.spring3.t0.common.entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.*;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@SuperBuilder
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    private UUID id;

    @Version
    @Builder.Default
    private Integer version = 0;

    @CreationTimestamp
    private LocalDateTime createAt;

    @Builder.Default
    private Boolean isDelete = Boolean.FALSE;

}
