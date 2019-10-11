package com.flow.domain.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-11 17:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageData<T> {
    /**
     * 分页数据
     */
    private T data;
    /**
     * 分页总数
     */
    private String count;
}
