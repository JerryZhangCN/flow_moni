package com.flow.domain.alarm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019-10-09 16:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alarm {
    /**
     * 河流名称
     */
    private String riverName;
    /**
     * 显示名称
     */
    private String name;
    /**
     * 数值
     */
    private String value;
    /**
     * 报警值
     */
    private String alarmLevelValue;

    /**
     * 报警级别
     */
    private String orderLevel;
}
