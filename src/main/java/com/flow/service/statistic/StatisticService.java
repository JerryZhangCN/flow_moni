package com.flow.service.statistic;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flow.domain.statistics.FlowData;
import com.flow.domain.statistics.PageData;
import com.flow.domain.statistics.Statistics;
import com.flow.domain.tools.DataConstants;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author jerry
 * @date 2019-10-10 20:09
 */
public interface StatisticService {
    Statistics query(String sttp, String groupId);

    PageData getFlowData(String addvcd, String scale, String start, String end, String key, String count, String index, String level, String timeScale);

    Statistics stationStatistics(String timeType, String stcd, String monitorPara);

    Statistics videoStatistics( String sttp, String groupId);
}
