package com.cyber009.spring3.t0.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@SuperBuilder
public class BaseDto {
    private UUID id;
    private Integer version;
    private LocalDateTime createAt;
}
