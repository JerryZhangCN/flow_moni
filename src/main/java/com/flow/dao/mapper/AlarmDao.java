package com.flow.dao.mapper;


import com.flow.domain.alarm.Alarm;
import com.flow.domain.area.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 22:28
 */
@Mapper
@Repository
public interface AlarmDao {

    List<Alarm> queryAlarm(@Param("addvcd") String Addvcd, @Param("sttp") String sttp, @Param("scale") String scale, @Param("key") String key);
}
