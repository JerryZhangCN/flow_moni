package com.flow.domain.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019-10-19 15:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FloatWindowData {
    /**
     * 测站名称
     */
    private String stationName;
    /**
     * 测站编码
     */
    private String stcd;
    /**
     * 计量方式
     */
    private String calcMode;

    //---------------  生态流量相关 -------------------
    /**
     * 最大值
     */
    private String maxValue;
    /**
     * 最小值
     */
    private String minValue;

    //  ------------ 取水计量流量相关 --------------------
    /**
     * 年审批量
     */
    private String yearApproval;
    /**
     * 实际流量
     */
    private String flow;

    // ------------ 河湖水质流量相关 ----------------------
    /**
     * 最优
     */
    private String bestValue;
    /**
     * 最劣
     */
    private String worstValue;


}
