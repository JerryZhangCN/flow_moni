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
     * 更改之前行政ID
     */
    private String beforeAddvcd;
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
     * 全称
     */
    private String allName;
    /**
     * 级别
     */
    private String level;
    /**
     * 面积
     */
    private String area;
    /**
     * 人口
     */
    private String population;
    /**
     * 家庭户数
     */
    private String households;
    /**
     * 经度
     */
    private String lttd;
    /**
     * 纬度
     */
    private String lgtd;
    /**
     * 修改时间
     */
    private String updateTime;
    /**
     * 级别名称
     */
    private String levelName;
    /**
     * 有效长度
     */
    private String length;
    /**
     * 排序
     */
    private String index;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 是否启用
     */
    private String enabled;
    /**
     * 该行政级别下的子级别
     */
    private ArrayList<Area> children = new ArrayList<>();
}
