package com.flow.domain.scale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019-10-09 14:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scale {
    /**
     * 测站类别
     */
    private String sttp;
    /**
     * 规模类别
     */
    private String scaleType;
    /**
     * 名称
     */
    private String name;
    /**
     * 规模名称
     */
    private String scaleName;
    /**
     * scale 值，用于站点查询
     */
    private String scale;
    /**
     * 规模最小值
     */
    private String scaleMin;
    /**
     * 规模最大值
     */
    private String scaleMax;

}
