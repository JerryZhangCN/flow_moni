package com.flow.dao.mapper;


import com.flow.domain.moniStation.MoniOnline;
import com.flow.domain.moniStation.MoniStation;
import com.flow.domain.moniStation.StationDetail;
import com.flow.domain.moniStation.StationType;
import com.flow.domain.tools.DataConstants;
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

    List<StationType> getMonitorType();


    List<MoniStation> findByGroupId(@Param(DataConstants.REQUEST_PARAMS_GROUP_ID) String group,
                                     @Param(DataConstants.STATION_STATUS_TYPE) String sttp);
}
