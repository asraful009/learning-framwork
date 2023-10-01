package com.cyber009.spring3security.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@SuperBuilder
@ToString
public class BaseDto {
    private UUID id;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private Integer version;
    private Boolean isDeleted = Boolean.FALSE;
}
