package com.flow.dao.mapper;


import com.flow.domain.area.Area;
import com.flow.domain.statistics.*;
import com.flow.domain.tools.DataConstants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author jerry
 * @date 2019-10-07 22:28
 */
@Mapper
@Repository
public interface StatisticsDao {

    Statistics query(@Param(DataConstants.STATION_STATUS_TYPE) String sttp, @Param(DataConstants.REQUEST_PARAMS_GROUP_ID) String groupId);

    List<List<Object>> getFlowData(@Param(DataConstants.MONI_STATION_ADDVCD) String addvcd,
                                   @Param(DataConstants.REQUEST_PARAMS_SCALE) String monitorPara,
                                   @Param(DataConstants.REQUEST_PARAMS_START) String start,
                                   @Param(DataConstants.REQUEST_PARAMS_END) String end,
                                   @Param(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                   @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                   @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index,
                                   @Param(DataConstants.REQUEST_PARAMS_ALARM_LEVEL) String level,
                                   @Param(DataConstants.REQUEST_PARAMS_TIME_SCALE) String timeScale);

    List<List<Object>> getUseFlowData(@Param(DataConstants.MONI_STATION_ADDVCD) String addvcd,
                                   @Param(DataConstants.STATION_STATUS_TYPE) String sttp,
                                   @Param(DataConstants.REQUEST_PARAMS_START) String start,
                                   @Param(DataConstants.REQUEST_PARAMS_END) String end,
                                   @Param(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                   @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                   @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index,
                                   @Param(DataConstants.REQUEST_PARAMS_ALARM_LEVEL) String level,
                                   @Param(DataConstants.REQUEST_PARAMS_TIME_SCALE) String timeScale);

    List<List<Object>> getWaterQualityData(@Param(DataConstants.MONI_STATION_ADDVCD) String addvcd,
                                      @Param(DataConstants.REQUEST_PARAMS_QUALITY_LEVEL) String qualityLevel,
                                      @Param(DataConstants.REQUEST_PARAMS_START) String start,
                                      @Param(DataConstants.REQUEST_PARAMS_END) String end,
                                      @Param(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                      @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                      @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index,
                                      @Param(DataConstants.REQUEST_PARAMS_ALARM_LEVEL) String level,
                                      @Param(DataConstants.REQUEST_PARAMS_MONITOR_TYPE) String monitorType);


    Statistics monthData(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd, @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara);

    Statistics seasonData(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd, @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara);

    Statistics yearData(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd, @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara);

    Statistics videoData(@Param(DataConstants.STATION_STATUS_TYPE) String sttp, @Param(DataConstants.REQUEST_PARAMS_GROUP_ID) String groupId);

    List<QualityLevel> qualityLevel();

    List<MonitorPara> monitorPara(@Param(DataConstants.STATION_STATUS_TYPE) String sttp);
}
