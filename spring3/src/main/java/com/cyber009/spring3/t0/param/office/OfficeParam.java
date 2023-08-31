package com.cyber009.spring3.t0.param.office;


import com.cyber009.spring3.t0.common.param.AddressParam;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode
public class OfficeParam {
    private String name;
    private AddressParam addressParam;
}
