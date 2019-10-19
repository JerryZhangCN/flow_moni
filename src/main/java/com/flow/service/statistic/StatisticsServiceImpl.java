package com.flow.service.statistic;

import com.flow.dao.mapper.StatisticsDao;
import com.flow.domain.statistics.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author jerry
 * @date 2019-10-10 20:10
 */
@Service
public class StatisticsServiceImpl implements StatisticService {

    @Autowired
    private StatisticsDao statisticsDao;

    @Override
    public Statistics query(String sttp, String groupId) {
        return statisticsDao.query(sttp, groupId);
    }

    @Override
    public PageData getFlowData(String addvcd, String monitorPara, String start, String end, String key, String count, String index, String level, String timeScale) {
        List<List<Object>> ob = statisticsDao.getFlowData(addvcd, monitorPara, start, end, key, count, index, level, timeScale);
        return new PageData(ob.get(0), ob.get(1).get(0).toString());
    }

    @Override
    public PageData getUseFlowData(String addvcd, String sttp, String start, String end, String key, String count, String index, String level, String timeScale) {
        List<List<Object>> ob = statisticsDao.getUseFlowData(addvcd, sttp, start, end, key, count, index, level, timeScale);
        return new PageData(ob.get(0), ob.get(1).get(0).toString());
    }

    @Override
    public PageData getWaterQuality(String addvcd, String qualityLevel, String start, String end, String key, String count, String index, String level, String monitorType) {
        List<List<Object>> ob = statisticsDao.getWaterQualityData(addvcd, qualityLevel, start, end, key, count, index, level, monitorType);
        return new PageData(ob.get(0), ob.get(1).get(0).toString());
    }

    @Override
    public Statistics stationStatistics(String timeType, String stcd, String monitorPara) {
        switch (timeType){
            case "month":{
                return statisticsDao.monthData(stcd,monitorPara);
            }
            case "season":{
                return statisticsDao.seasonData(stcd,monitorPara);
            }
            case "year":{
                return statisticsDao.yearData(stcd,monitorPara);
            }
            default:{
                return statisticsDao.monthData(stcd,monitorPara);
            }
        }
    }

    @Override
    public Statistics videoStatistics(String sttp, String groupId) {
        return statisticsDao.videoData(sttp,groupId);
    }

    @Override
    public List<QualityLevel> getQualityLevel() {
        return statisticsDao.qualityLevel();
    }

    @Override
    public List<MonitorPara> getMotorPara(String sttp) {
        return statisticsDao.monitorPara(sttp);
    }
}
