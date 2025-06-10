package com.cyber009.s3t2.dto;

import com.cyber009.s3t2.enums.EndPointMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EndPointDto implements Serializable {
    private Integer id;
    private String name;
    private EndPointMethod method;
    private String endPoint;
}
