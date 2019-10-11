package com.flow.domain.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019-10-11 9:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurveData {
    /**
     * 时间
     */
    private String time;
    /**
     * 数值
     */
    private String value;
    /**
     * 监测标准值
     */
    private String alarmValue;
}
