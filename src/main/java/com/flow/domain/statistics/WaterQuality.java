package com.flow.domain.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019-10-17 17:09
 * 河湖水质
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WaterQuality {
    /**
     * 侧站编码
     */
    private String stcd;
    /**
     * 河流名称
     */
    private String riverName;
    /**
     * 水质等级
     */
    private String qualityLevel;
    /**
     * 测站名称
     */
    private String stationName;
    /**
     * 监测方式
     */
    private String monitorType;
    /**
     * 监测人
     */
    private String monitorUser;
    /**
     * 监测时间
     */
    private String monitorTime;
    /**
     * cod
     */
    private String cod;
    /**
     * NH3-N
     */
    private String an;
    /**
     * 总磷
     */
    private String tp;
    /**
     * 总氮
     */
    private String tn;
    /**
     * PH
     */
    private String ph;
    /**
     * 高锰酸盐
     */
    private String pg;
    /**
     * 大肠杆菌
     */
    private String cc;
    /**
     * 电导率
     */
    private String er;
    /**
     * 浑浊度
     */
    private String tb;
    /**
     * 水温
     */
    private String wt;

}
