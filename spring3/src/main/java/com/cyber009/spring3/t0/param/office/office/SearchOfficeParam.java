package com.cyber009.spring3.t0.param.office.office;

import com.cyber009.spring3.t0.common.param.BaseSearchParam;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class SearchOfficeParam extends BaseSearchParam {
    @Builder.Default
    private String name = "";
}
