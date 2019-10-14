package com.flow.service.statistic;

import com.flow.dao.mapper.StatisticsDao;
import com.flow.domain.statistics.FlowData;
import com.flow.domain.statistics.PageData;
import com.flow.domain.statistics.Statistics;
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
}
