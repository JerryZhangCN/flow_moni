package com.flow.dao.mapper;


import com.flow.domain.area.Area;
import com.flow.domain.moniStation.MoniStation;
import com.flow.domain.scale.Group;
import com.flow.domain.tools.BaseReturnData;
import com.flow.domain.tools.DataConstants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 22:28
 */
@Mapper
@Repository
public interface AreaDao {

    List<Area> queryAll();

    List<Area> findByAddvcd(String Addvcd);

    List<Group> getGroup(@Param(DataConstants.STATION_STATUS_TYPE) String sttp);

    List<List<Object>> getAreaByAddvcd(@Param(DataConstants.MONI_STATION_ADDVCD) String addvcd,
                                       @Param(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                       @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                       @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index);

    List<List<Object>> createArea(@Param(DataConstants.MONI_STATION_ADDVCD) String addvcd);

    BaseReturnData saveArea(Area area);
}
