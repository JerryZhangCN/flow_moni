package com.flow.dao.mapper;


import com.flow.domain.alarm.Alarm;
import com.flow.domain.alarm.AlarmInterval;
import com.flow.domain.alarm.AlarmSetting;
import com.flow.domain.area.Area;
import com.flow.domain.tools.DataConstants;
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

    List<Alarm> queryByGroupId(@Param("addvcd") String Addvcd, @Param("sttp") String sttp, @Param(DataConstants.REQUEST_PARAMS_GROUP_ID) String groupId, @Param("key") String key);

    List<List<Object>> queryAlarmSetting(@Param(DataConstants.STATION_STATUS_TYPE) String sttp,
                                         @Param(DataConstants.REQUEST_PARAMS_GROUP_ID) String groupId,
                                         @Param(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                         @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                         @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index);

    AlarmSetting getSettingDetail(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                  @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara,
                                  @Param(DataConstants.REQUEST_PARAMS_ALARM_INTERVAL) String alarmInterval);


    List<AlarmInterval> getAlarmInterval();

    List<AlarmInterval> getAlarmMethod();

    AlarmSetting createAlarm(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd);

    AlarmSetting saveAlarm(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                           @Param(DataConstants.REQUEST_PARAMS_BEFORE_ALARM_PARA) String beforeMonitorPara,
                           @Param(DataConstants.REQUEST_PARAMS_BEFORE_ALARM_INTERVAL) String beforeAlarmInterval,
                           @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara,
                           @Param(DataConstants.REQUEST_PARAMS_ALARM_INTERVAL) String alarmInterval,
                           @Param(DataConstants.REQUEST_PARAMS_BEFORE_ALARM_COMPARE_METHOD) String compareType,
                           @Param(DataConstants.REQUEST_PARAMS_ONE_LEVEL_ALARM) String oneLevelAlarmValue,
                           @Param(DataConstants.REQUEST_PARAMS_TWO_LEVEL_ALARM) String twoLevelAlarmValue,
                           @Param(DataConstants.REQUEST_PARAMS_ALARM_METHOD) String alarmMethod,
                           @Param(DataConstants.REQUEST_PARAMS_ALARM_FORM) String alarmForm);


    List<List<Object>> alarmHistory(@Param(DataConstants.STATION_STATUS_TYPE) String sttp,
                                         @Param(DataConstants.REQUEST_PARAMS_GROUP_ID) String groupId,
                                         @Param(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                         @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                         @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index);


}
