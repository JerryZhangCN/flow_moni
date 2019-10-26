package com.flow.domain.alarm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019/10/25 17:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlarmInterval {
    /**
     * 报警时段
     */
    private String alarmInterval;
    /**
     * 报警时段名称
     */
    private String alarmIntervalName;
    /**
     * 报警方式
     */
    private String alarmMethod;
    /**
     * 报警方式名称
     */
    private String alarmMethodName;
}
