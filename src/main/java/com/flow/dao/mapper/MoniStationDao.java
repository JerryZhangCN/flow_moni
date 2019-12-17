package com.flow.dao.mapper;


import com.flow.domain.moniStation.*;
import com.flow.domain.tools.BaseReturnData;
import com.flow.domain.tools.DataConstants;
import com.flow.domain.video.Video;
import com.google.common.util.concurrent.ListenableFuture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 22:28
 */
@Mapper
@Repository
public interface MoniStationDao {

    List<MoniStation> findByAddvcdAndScale(@Param(DataConstants.MONI_STATION_ADDVCD) String addvcd,
                                           @Param(DataConstants.STATION_STATUS_TYPE) String sttp,
                                           @Param(DataConstants.REQUEST_PARAMS_SCALE) String scale);

    List<MoniOnline> monitorOnline(@Param(DataConstants.MONI_STATION_ADDVCD) String addvcd,
                                   @Param(DataConstants.STATION_STATUS_TYPE) String sttp,
                                   @Param(DataConstants.REQUEST_PARAMS_GROUP_ID) String groupId,
                                   @Param(DataConstants.REQUEST_PARAMS_KEYS) String key);

    List<StationDetail> getStationDetail(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                         @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara);

    HomeStationDetail homeStationDetail(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd);

    List<StationType> getMonitorType(@Param(DataConstants.REQUEST_PARAMS_TYPE) String type,
                                     @Param(DataConstants.STATION_STATUS_TYPE) String sttp);

    List<StationType> getHomeType();


    List<MoniStation> findByGroupId(@Param(DataConstants.REQUEST_PARAMS_GROUP_ID) String group,
                                    @Param(DataConstants.STATION_STATUS_TYPE) String sttp);

    List<Video> groupStation(@Param(DataConstants.REQUEST_PARAMS_GROUP_ID) String groupId,
                             @Param(DataConstants.REQUEST_PARAMS_KEYS) String key);


    List<List<Object>> operationStations(@Param(DataConstants.STATION_STATUS_TYPE) String sttp,
                                         @Param(DataConstants.REQUEST_PARAMS_GROUP_ID) String groupId,
                                         @Param(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                         @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                         @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index);

    StationMsg operationDetail(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd);

    List<StationStatus> stationStatus(@Param(DataConstants.STATION_STATUS_TYPE) String sttp);

    List<ConvertMethod> getConvertMethod(@Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara);

    List<GB> getGB();

    List<List<Object>> createStation(@Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara);

    BaseReturnData saveStation(StationMsg stationMsg);


    List<BaseBoxData> stationScaleType();

    List<BaseBoxData> stationType();

    List<BaseBoxData> stationSon(@Param(DataConstants.STATION_STATUS_TYPE) String sttp);

    List<BaseBoxData> stationScale(@Param(DataConstants.STATION_STATUS_TYPE) String sttp,
                                   @Param("scaleType") String scaleType);

    List<BaseBoxData> gbLevel();
}
