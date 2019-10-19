package com.flow.domain.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019-10-17 20:13
 * 监测等级
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QualityLevel {
    /**
     * 名称
     */
    private String levelName;
    /**
     * 等级
     */
    private String level;

}
