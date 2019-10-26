package com.flow.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019/10/25 14:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
    /**
     * 组织ID
     */
    private String organizationId;
    /**
     * 组织名
     */
    private String organizationName;
    /**
     * 选中
     */
    private String isSelected;
    /**
     * 总数量
     */
    private String totalCount;

}
