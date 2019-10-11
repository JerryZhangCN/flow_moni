package com.flow.domain.moniStation;

import com.flow.domain.scale.Scale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jerry
 * @date 2019-10-10 14:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationType {
    /**
     * 类别码
     */
    private String sttp;
    /**
     * 名称
     */
    private String name;
    /**
     * 规模列表
     */
    private List<Scale> scales = new ArrayList<>();
}
