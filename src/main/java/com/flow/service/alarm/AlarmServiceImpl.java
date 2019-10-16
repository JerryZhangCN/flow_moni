package com.flow.service.alarm;

import com.flow.dao.mapper.AlarmDao;
import com.flow.domain.alarm.Alarm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-09 16:28
 */
@Service
public class AlarmServiceImpl implements AlarmService {
    @Autowired
    private AlarmDao alarmDao;

    @Override
    public List<Alarm> queryAlarm(String addvcd, String sttp, String scale, String key) {
        return alarmDao.queryAlarm(addvcd, sttp, scale, key);
    }

    @Override
    public List<Alarm> queryAlarmByGroupId(String addvcd, String http, String groupId, String key) {
        return alarmDao.queryByGroupId(addvcd, http, groupId, key);
    }
}
