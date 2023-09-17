package com.cyber009.spring3.t0.common.instance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Data
@SuperBuilder
@ToString
@Slf4j
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class InstanceCreateEvent {
    @JsonProperty("instanceId")
    private UUID instanceId;
    @JsonProperty("entityName")
    private String entityName;
}
