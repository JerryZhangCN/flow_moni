package com.flow.domain.video;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

/**
 * @author jerry
 * @date 2019/10/19 23:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoOnline {
    /**
     * 测站编码
     */
    private String stcd;
    /**
     * 测站名称
     */
    private String stationName;
    /**
     * 参数名称
     */
    private String flowName;
    /**
     * 参数值
     */
    private String flowValue;
    /**
     * 预警值
     */
    private String alarmValue;
    /**
     * 时间
     */
    private String time;
}
