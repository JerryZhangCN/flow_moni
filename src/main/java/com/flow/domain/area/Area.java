package com.flow.domain.area;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author jerry
 * @date 2019-10-09 13:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Area {
    /**
     * ID
     */
    private String id;
    /**
     * 行政ID
     */
    private String addvcd;
    /**
     * 父级行政ID
     */
    private String pAddvcd;
    /**
     * 名称
     */
    private String name;
    /**
     * 级别
     */
    private String level;
    /**
     * 级别名称
     */
    private String levelName;
    /**
     * 该行政级别下的子级别
     */
    private ArrayList<Area> children = new ArrayList<>();
}
