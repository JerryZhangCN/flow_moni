package com.flow.domain.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019-10-11 14:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowData {
    /**
     * 测站编码
     */
    private String stcd;
    /**
     * 所属地区
     */
    private String address;
    /**
     * 测站名称
     */
    private String stationName;
    /**
     * 记录时间
     */
    private String time;
    /**
     * 水位
     */
    private String waterLevel;
    /**
     * 水头
     */
    private String waterHeader;
    /**
     * 流速
     */
    private String speed;
    /**
     * 下泄流量
     */
    private String leakFlow;
    /**
     * 下泄标准
     */
    private String leakStandard;
    /**
     * 总流量
     */
    private String totalFlow;
    /**
     * 下泄比
     */
    private String preValue;
    /**
     * 同比
     */
    private String contrast;
    /**
     * 警戒阈值
     */
    private String twoLevelAlarm;
    /**
     * 保证阈值
     */
    private String oneLevelAlarm;
    /**
     * 闸位
     */
    private String gate;
}
