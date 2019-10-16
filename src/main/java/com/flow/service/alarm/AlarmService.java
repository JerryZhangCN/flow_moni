package com.flow.service.alarm;

import com.flow.domain.alarm.Alarm;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-09 16:26
 */
public interface AlarmService {
    List<Alarm> queryAlarm(String Addvcd, String http, String scale, String key);

    List<Alarm> queryAlarmByGroupId(String Addvcd, String http, String groupId, String key);
}
