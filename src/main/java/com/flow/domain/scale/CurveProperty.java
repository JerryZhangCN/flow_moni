package com.flow.domain.scale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

/**
 * @author jerry
 * @date 2019-10-19 16:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurveProperty {

    /**
     * 横向
     */
    private String landScape;
    /**
     * 纵向
     */
    private String portrait;
    /**
     * 单位
     */
    private String unit;
    /**
     * 标准值
     */
    private String alarmValue;

    private String quality;
    private String qualityValue;
    private String waterQuality;
    private String name;
    private String best;
    private String worst;

}
