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

    /**
     * 测站编码
     */
    private String stcd;
    /**
     * 监测指标
     */
    private String monitorPara;
    /**
     * 测站名称
     */
    private String stationName;
    /**
     * 所属乡镇
     */
    private String addressName;
    /**
     * 测站类别
     */
    private String stationType;
    /**
     * 报警时间
     */
    private String time;
    /**
     * 报警级别
     */
    private String alarmLevel;
    /**
     * 报警时段
     */
    private String alarmInterval;
    /**
     * 报警阈值
     */
    private String levelValue;
    /**
     * 实测值
     */
    private String realValue;
    /**
     * 报警方式
     */
    private String alarmMethod;
    /**
     * 报警内容
     */
    private String alarmForm;
    /**
     * 已发送短信人数
     */
    private String alreadyReleaseNumber;
    /**
     * 共发布人数
     */
    private String preReleaseNumber;
    /**
     * 操作
     */
    private String operation;
}
