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

    List<MoniStation> queryAll();

    List<MoniStation> findByAddvcd(String Addvcd);
}
