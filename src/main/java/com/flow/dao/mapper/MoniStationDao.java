package com.flow.dao.mapper;


import com.flow.domain.moniStation.MoniStation;
import org.apache.ibatis.annotations.Mapper;
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

    @Select("EXEC [P_M_StationBasis] NULL,NULL,NULL,NULL,NULL,NULL")
    List<MoniStation> queryAll();
}
