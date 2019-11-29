package com.flow.domain.moniStation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019-10-09 18:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationDetail {
    /**
     * 保存前测站编码
     */
    private String beforeStcd;
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
     * 监测指标
     */
    private String monitorPara;
    /**
     * 设计流量
     */
    private String designFlow;
    /**
     * 设计流量值
     */
    private String designFlowValue;
    /**
     * 下泄量
     */
    private String leakFlow;
    /**
     * 下泄流量值
     */
    private String leakFlowValue;
    /**
     * 精度
     */
    private String lttd;
    /**
     * 纬度
     */
    private String lgtd;
    /**
     * 建设年月
     */
    private String createTime;
    /**
     * 设计单位
     */
    private String designDepart;
    /**
     * 监测时间
     */
    private String monitorTime;
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
     * 二维码
     */
    private String qrCode;
    /**
     * 测站编码
     */
    private String stcd;
    /**
     * 流域
     */
    private String basin;
    /**
     * 基面高层
     */
    private String baseTop;
    /**
     * 泄流方式
     */
    private String discharge;
    /**
     * 换算方式
     */
    private String convert;
    /**
     * 国标
     */
    private String gb;
    /**
     * 国标级别
     */
    private String gbLevel;
    /**
     * 平台IP
     */
    private String ptIp;
    /**
     * 平台端口
     */
    private String ptPort;
    /**
     * 平台通道
     */
    private String ptChannel;
    /**
     * 平台用户
     */
    private String ptUser;
    /**
     * 平台密码
     */
    private String ptPassword;
    /**
     * 是否启用
     */
    private String isOpen;
    /**
     * 检测方式
     */
    private String testMethod;
    /**
     * 备注
     */
    private String format;

}
