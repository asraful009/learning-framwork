package com.cyber009.spring3.t0.common.param;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
public class BaseSearchParam {
    private Integer pageNo;
    private Integer pageSize;


    public PageRequest getPageable() {
        if(pageNo == null) { this.pageNo = 1;}
        else if (pageNo < 1) { this.pageNo = 1;}
        this.pageNo = pageNo;

        if(pageSize == null) { this.pageSize = 10;}
        else if (pageSize < 1 || pageSize > 20) { this.pageSize = 20;}
        this.pageSize = pageSize;
        PageRequest pageable = PageRequest.of(pageNo, pageSize);

        return pageable;
    }
}
