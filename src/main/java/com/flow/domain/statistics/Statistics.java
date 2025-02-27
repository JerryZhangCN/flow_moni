package com.flow.domain.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019-10-10 19:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {

    /**
     * 监测类型
     */
    private String monitorType;
    /**
     * 总数量
     */
    private String totalNumber;
    /**
     * 不达标数量
     */
    private String alarm;
    /**
     * 正常数量
     */
    private String correctNumber;
    /**
     * 离线数量
     */
    private String offlineNumber;

    /**
     * 离线数量
     */
    private String onlineNumber;

}
