package com.cyber009.spring3.t0.common.param;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.UUID;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
public class BaseSearchParam {
    private Integer pageNo;
    private Integer pageSize;
    private UUID appUserId;


    public PageRequest getPageable() {
        if(pageNo == null) { this.pageNo = 1;}
        else if (pageNo < 1) { this.pageNo = 1;}

        if(pageSize == null) { this.pageSize = 10;}
        else if (pageSize < 1 || pageSize > 20) { this.pageSize = 20;}
        Sort sort = Sort.by(Sort.Order.desc("createAt"));
        PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);
        return pageable;
    }
}
