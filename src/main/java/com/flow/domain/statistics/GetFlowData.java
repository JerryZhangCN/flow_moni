package com.flow.domain.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019-10-17 9:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetFlowData {
    /**
     * 测站编码
     */
    private String stcd;
    /**
     * 所属乡镇
     */
    private String address;
    /**
     * 取水类型
     */
    private String sonsName;
    /**
     * 取水用户
     */
    private String userName;
    /**
     * 时间
     */
    private String time;
    /**
     * 水位
     */
    private String waterLevel;
    /**
     * 流速
     */
    private String speed;
    /**
     * 实时流量
     */
    private String leakFlow;
    /**
     * 统计时段
     */
    private String countTime;
    /**
     * 统计流量
     */
    private String countFlow;
    /**
     * 年审批量
     */
    private String alarmValue;
    /**
     * 总流量
     */
    private String totalFlow;
}
