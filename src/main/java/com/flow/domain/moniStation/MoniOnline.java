package com.flow.domain.moniStation;

import lombok.Data;

/**
 * @author jerry
 * @date 2019-10-07 16:03
 */
@Data
public class MoniOnline {

    /**
     * 监测站名称
     */
    private String stnmShwo;

    /**
     * 监测类型
     */
    private String ShowMonitorTypeNM;

    /**
     * 监测值
     */
    private String value;

    /**
     * 时间
     */
    private String TMShow;


}
