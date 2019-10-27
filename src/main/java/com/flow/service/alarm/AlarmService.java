package com.flow.service.alarm;

import com.flow.domain.alarm.Alarm;
import com.flow.domain.alarm.AlarmInterval;
import com.flow.domain.alarm.AlarmSetting;
import com.flow.domain.alarm.CompareType;
import com.flow.domain.statistics.MonitorPara;
import com.flow.domain.statistics.PageData;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-09 16:26
 */
public interface AlarmService {
    List<Alarm> queryAlarm(String Addvcd, String http, String scale, String key);

    List<Alarm> queryAlarmByGroupId(String Addvcd, String http, String groupId, String key);

    PageData getAlarmSetting(String http, String groupId, String key, String count, String index);

    AlarmSetting settingDetail(String tscd, String monitorPara, String alarmInterval);

    List<AlarmInterval> getAlarmInterval();

    List<AlarmInterval> getAlarmMethod();

    AlarmSetting createAlarm(String tscd);

    AlarmSetting saveAlarm(String stcd,
                           String beforeMonitorPara,
                           String beforeAlarmInterval,
                           String monitorPara,
                           String alarmInterval,
                           String compareType,
                           String oneLevelAlarmValue,
                           String twoLevelAlarmValue,
                           String alarmMethod,
                           String alarmForm);

    PageData getAlarmHistory(String sttp, String groupId, String key, String count, String index);

    List<CompareType> getCompareType();

}
