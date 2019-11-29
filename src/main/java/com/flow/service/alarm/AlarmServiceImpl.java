package com.flow.service.alarm;

import com.flow.dao.mapper.AlarmDao;
import com.flow.domain.alarm.*;
import com.flow.domain.statistics.PageData;
import com.flow.domain.tools.BaseReturnData;
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

    @Override
    public PageData getAlarmSetting(String sttp, String groupId, String key, String count, String index) {
        List<List<Object>> result = alarmDao.queryAlarmSetting(sttp, groupId, key, count, index);
        return new PageData(result.get(0), result.get(1).get(0).toString());
    }

    @Override
    public List<AlarmInterval> getAlarmInterval() {
        return alarmDao.getAlarmInterval();
    }

    @Override
    public List<AlarmInterval> getAlarmMethod() {
        return alarmDao.getAlarmMethod();
    }

    @Override
    public AlarmSetting createAlarm(String stcd) {
        return alarmDao.createAlarm(stcd);
    }

    @Override
    public AlarmSetting saveAlarm(String stcd, String beforeMonitorPara, String beforeAlarmInterval, String monitorPara, String alarmInterval, String compareType, String oneLevelAlarmValue, String twoLevelAlarmValue, String alarmMethod, String alarmForm) {
        return alarmDao.saveAlarm(stcd, beforeMonitorPara, beforeAlarmInterval, monitorPara, alarmInterval, compareType, oneLevelAlarmValue, twoLevelAlarmValue, alarmMethod, alarmForm);
    }

    @Override
    public PageData getAlarmHistory(String sttp, String groupId, String key, String count, String index) {
        List<List<Object>> result = alarmDao.alarmHistory(sttp, groupId, key, count, index);
        return new PageData(result.get(0), result.get(1).get(0).toString());
    }

    @Override
    public List<CompareType> getCompareType() {
        return alarmDao.compareType();
    }

    @Override
    public List<AlarmMsg> alarmMsg() {
        return alarmDao.alarmMsg();
    }

    @Override
    public BaseReturnData updateAlarmMsg(AlarmMsg alarmMsg) {
       return alarmDao.updateAlarmMsg(alarmMsg);
    }

    @Override
    public AlarmSetting settingDetail(String tscd, String monitorPara, String alarmInterval) {
        return alarmDao.getSettingDetail(tscd, monitorPara, alarmInterval);
    }
}
