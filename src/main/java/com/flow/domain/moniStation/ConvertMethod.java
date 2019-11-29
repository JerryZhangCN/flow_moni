package com.flow.domain.moniStation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019/11/6 19:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConvertMethod {

    /**
     * 检测指标
     */
    private String monitorPara;
    /**
     * 转换方式ID
     */
    private String convertId;
    /**
     * 转换方式
     */
    private String convert;

}
