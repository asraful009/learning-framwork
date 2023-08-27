package com.cyber009.spring3.t0.dto;


import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@SuperBuilder
public class WorkFlowDto extends BaseDto {
    private String title;
}
