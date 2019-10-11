package com.flow.domain.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019-10-11 11:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    /**
     * 图片位置
     */
    private String position;
    /**
     * 图片采集时间
     */
    private String pictureTime;
    /**
     * 监测站编码
     */
    private String stcd;
    /**
     * 数据时间
     */
    private String valueTime;
    /**
     * 数据1名称
     */
    private String value1Name;
    /**
     * 数据1值
     */
    private String value1;
    /**
     * 数据2名称
     */
    private String value2Name;
    /**
     * 数据2值
     */
    private String value2;
    /**
     * 监测站名称
     */
    private String stationName;
    /**
     * 标准名称
     */
    private String alarmLevel;
    /**
     * 标准值
     */
    private String alarmLevelValue;

}
