package com.flow.domain.alarm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019/10/27 20:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompareType {
    /**
     * 比较类型
     */
    private String compareType;
    /**
     * 比较类型名称
     */
    private String compareTypeName;
}
