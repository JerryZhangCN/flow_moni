package com.flow.domain.alarm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

/**
 * @author jerry
 * @date 2019/10/22 17:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlarmSetting {


    private String stcd;
    /**
     * 所属乡镇
     */
    private String address;
    /**
     * 测站类别
     */
    private String stationType;
    /**
     * 测站类别
     */
    private String stationTypeName;
    /**
     * 测站名称
     */
    private String stationName;
    /**
     * 报警指标
     */
    private String monitorPara;
    /**
     * 报警指标
     */
    private String monitorParaName;
    /**
     * 报警时段
     */
    private String alarmInterval;
    /**
     * 报警时段
     */
    private String alarmIntervalName;
    /**
     * 比较类型
     */
    private String compareType;
    /**
     * 一级阈值
     */
    private String oneLevelAlarmValue;
    /**
     * 二级阈值
     */
    private String twoLevelAlarmValue;
    /**
     * 报警阈值
     */
    private String alarmMethod;
    /**
     * 报警格式
     */
    private String alarmForm;

    /**
     * 行政区划ID
     */
    private String addvcd;

    /**
     * 总数量
     */
    private String totalCount;
    /**
     * 更新条数
     */
    private String updateCount;
    /**
     * 创建结果
     */
    private String result;

}
