package com.cyber009.spring3.t0.param.appuser;

import com.cyber009.spring3.t0.common.param.BaseSearchParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class SearchAppUserParam extends BaseSearchParam {
    private String name;
}
