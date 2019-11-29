package com.flow.domain.tools;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jerry
 * @date 2019/11/6 16:38
 * 执行数据存储过程后，返回的第二的数据集解析
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseReturnData {

    /**
     * 返回记录数据
     */
    private String resultData;
    /**
     * 总记录数
     */
    private String totalCount;
    /**
     * 更新条数
     */
    private String updateCount;
    /**
     * 返回值
     */
    private String result;


}
