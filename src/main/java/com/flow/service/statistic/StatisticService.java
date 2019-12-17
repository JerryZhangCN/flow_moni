package com.flow.service.statistic;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flow.domain.statistics.*;
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

    PageData getFlowData(String type, String addvcd, String scale, String start, String end, String key, String count, String index, String level, String timeScale);

    PageData getUseFlowData(String addvcd, String sttp, String start, String end, String key, String count, String index, String level, String timeScale);

    PageData getWaterQuality(String addvcd, String qualityLevel, String start, String end, String key, String count, String index, String level, String monitorType);

    Statistics stationStatistics(String timeType, String stcd, String monitorPara);

    Statistics videoStatistics(String sttp, String groupId);

    List<QualityLevel> getQualityLevel();

    List<MonitorPara> getMotorPara(String sttp);
}
