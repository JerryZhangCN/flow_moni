package com.flow.domain.moniStation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 首页弹出框，测站基础信息，视频检测页面测站信息
 *
 * @author jerry
 * @date 2019-10-09 18:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeStationDetail {
    /**
     * 测站名称
     */
    private String stationName;
    /**
     * 测站地址
     */
    private String stationAddress;
    /**
     * 测站类型
     */
    private String stationType;
    /**
     * 测站状态
     */
    private String stationStatus;
    /**
     * 监控状态
     */
    private String stationLine;
    /**
     * 标准值
     */
    private String oneLevelAlarm;
    /**
     * 实测值
     */
    private String value;
    /**
     * 监测时间
     */
    private String monitorTime;
    /**
     * 糙率系数
     */
    private String sl_zn;
    /**
     * 坡度系数
     */
    private String sl_pd;
    /**
     * 淹没系数
     */
    private String sl_ym;
    /**
     * 收缩系数
     */
    private String sl_ss;
    /**
     * 测站编码
     */
    private String stcd;
    /**
     * 精度
     */
    private String lttd;
    /**
     * 纬度
     */
    private String lgtd;
    /**
     * 监测指标
     */
    private String monitorPara;
    /**
     * 主要指标
     */
    private String mainMonitorPara;
    /**
     * 计算方式
     */
    private String convert;
    /**
     * 工程措施
     */
    private String leakProject;
    /**
     * 设备厂家
     */
    private String equipmentManufacturers;
    /**
     * 工程宽
     */
    private String sl_w;
    /**
     * 工程高
     */
    private String sl_h;
    /**
     * 管径
     */
    private String sl_gl;
    /**
     * 管长
     */
    private String sl_gc;
    /**
     * 流量系数
     */
    private String sl_ll;
    /**
     * 工程名称
     */
    private String projectName;
    /**
     * 河流名称
     */
    private String riverName;
    /**
     * 规模
     */
    private String scaleType;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 单位
     */
    private String depart;
    /**
     * 装机容量
     */
    private String scaleValue;
    /**
     * 联系电话
     */
    private String contactPhone;
    /**
     * 工程基本信息
     */
    private String projectNote;
    /**
     * 建设年月
     */
    private String createTime;

}
