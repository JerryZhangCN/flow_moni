package com.flow.dao.mapper;


import com.flow.domain.area.Area;
import com.flow.domain.moniStation.MoniStation;
import com.flow.domain.scale.Group;
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

    List<Group> getGroup(@Param(DataConstants.STATION_STATUS_TYPE)String sttp);
}
