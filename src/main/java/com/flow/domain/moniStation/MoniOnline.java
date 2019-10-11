package com.flow.domain.moniStation;

import com.flow.domain.scale.Scale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 16:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoniOnline {

    /**
     * 监测站名称
     */
    private String stationName;

    /**
     * 监测站详细名称
     */
    private String statioNameAll;

    /**
     * 监测类型
     */
    private String showMonitorType;

    /**
     * 监测值
     */
    private String value;

    /**
     * 时间
     */
    private String time;
    /**
     * 监测站编号
     */
    private String stcd;
    /**
     * 监测值
     */
    private String monitorPara;

}
