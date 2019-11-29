package com.flow.domain.moniStation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019/11/7 21:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationMsg {
    /**
     * 保存前测站编码
     */
    private String beforeStcd;
    /**
     * 测站编码
     */
    private String stcd;
    /**
     * 测站名称
     */
    private String stationName;
    /**
     * 规模ID
     */
    private String scaleTypeId;
    /**
     * 规模名称
     */
    private String scaleTypeName;
    /**
     * 河流名称
     */
    private String riverName;
    /**
     * 流域
     */
    private String basin;
    /**
     * 经度
     */
    private String lttd;
    /**
     * 纬度
     */
    private String lgtd;
    /**
     * 基面高层
     */
    private String baseTop;
    /**
     * 泄流方式
     */
    private String discharge;
    /**
     * 监测指标
     */
    private String monitorPara;
    /**
     * 换算方式
     */
    private String convert;
    /**
     * 二维码
     */
    private String qrCode;
    /**
     * 国标
     */
    private String gb;
    /**
     * 国标级别
     */
    private String gbLevel;
    /**
     * 负责人
     */
    private String contact;
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
     * 流量系数
     */
    private String sl_ll;
    /**
     * 测站显示名称
     */
    private String stationNameShow;
    /**
     * 所在工程
     */
    private String projectName;
    /**
     * 测站类型
     */
    private String stationType;
    /**
     * 测站子类
     */
    private String sonStationType;
    /**
     * 所在水系
     */
    private String riverSystem;
    /**
     * 行政区划
     */
    private String addvcd;
    /**
     * 测站地址
     */
    private String stationAddress;
    /**
     * 管理单位
     */
    private String depart;
    /**
     * 建设年月
     */
    private String createTime;
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
     * 检测方式
     */
    private String testMethod;
    /**
     * 联系电话
     */
    private String contactPhone;
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
     * 是否启用
     */
    private String enabled;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 雨量
     */
    private String mppt;
    /**
     * 水位
     */
    private String mWater;
    /**
     * 图像
     */
    private String mImage;
    /**
     * 视频
     */
    private String mVideo;
    /**
     * 闸位
     */
    private String mGate;
    /**
     * 流量
     */
    private String designFlow;
    /**
     * 流速
     */
    private String speed;
    /**
     * 水温
     */
    private String waterTemperature;
    /**
     * ph
     */
    private String ph;
    /**
     * 溶解
     */
    private String mdon;
    /**
     * 电导
     */
    private String mern;
    /**
     * 浊度
     */
    private String mtbn;
    /**
     * 高锰酸钾
     */
    private String mpgn;
    /**
     * 氨氮
     */
    private String mann;
    /**
     * 总磷
     */
    private String mtpn;
    /**
     * 总氮
     */
    private String mtnn;
    /**
     * 气温
     */
    private String matn;
    /**
     * 湿度
     */
    private String mhn;
    /**
     * 蒸发
     */
    private String men;
    /**
     * 风速
     */
    private String mwsn;
    /**
     * 风向
     */
    private String mwdn;
    /**
     * 墒情
     */
    private String msmcn;
}
