package com.cyber009.spring3.t0.entity;


import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.*;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;


import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@SuperBuilder
@MappedSuperclass
public class BaseEntity {
    @Id
    private UUID id;

    @Version
    private Integer version;

    @CreatedDate
    private LocalDateTime createAt;


}
