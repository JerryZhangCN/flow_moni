package com.flow.domain.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019-10-17 20:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonitorPara {
    /**
     * 名称
     */
    private String monitorName;
    /**
     * 监测指标
     */
    private String monitorPara;
}
