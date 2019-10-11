package com.flow.dao.mapper;

import com.flow.domain.statistics.CurveData;
import com.flow.domain.tools.DataConstants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-11 10:08
 */
@Mapper
@Repository
public interface CurveDao {

    List<CurveData> findByStcdAndPara(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd, @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara);
}
