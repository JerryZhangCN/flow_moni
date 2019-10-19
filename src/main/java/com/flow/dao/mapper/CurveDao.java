package com.flow.dao.mapper;

import com.flow.domain.statistics.CurveData;
import com.flow.domain.statistics.FloatWindowData;
import com.flow.domain.tools.DataConstants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-11 10:08
 */
@Mapper
@Repository
public interface CurveDao {

    List<CurveData> findByStcdAndPara(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd, @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara);

    List<List<Object>> findFlowData(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                 @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara,
                                 @Param(DataConstants.REQUEST_PARAMS_START) String start,
                                 @Param(DataConstants.REQUEST_PARAMS_END) String end);

    List<List<Object>> findWaterData(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                 @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara,
                                 @Param(DataConstants.REQUEST_PARAMS_START) String start,
                                 @Param(DataConstants.REQUEST_PARAMS_END) String end);

    List<List<Object>> findQualityData(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                     @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara,
                                     @Param(DataConstants.REQUEST_PARAMS_START) String start,
                                     @Param(DataConstants.REQUEST_PARAMS_END) String end);

    FloatWindowData flowFloatData(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                  @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara,
                                  @Param(DataConstants.REQUEST_PARAMS_START) String start,
                                  @Param(DataConstants.REQUEST_PARAMS_END) String end);

    FloatWindowData waterFloatData(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                   @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara,
                                   @Param(DataConstants.REQUEST_PARAMS_START) String start,
                                   @Param(DataConstants.REQUEST_PARAMS_END) String end);

    FloatWindowData qualityFloatData(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                     @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara,
                                     @Param(DataConstants.REQUEST_PARAMS_START) String start,
                                     @Param(DataConstants.REQUEST_PARAMS_END) String end);
}
