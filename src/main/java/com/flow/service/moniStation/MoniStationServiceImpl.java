package com.flow.service.moniStation;


import com.flow.dao.mapper.MoniStationDao;
import com.flow.domain.moniStation.MoniOnline;
import com.flow.domain.moniStation.MoniStation;
import com.flow.domain.moniStation.StationDetail;
import com.flow.domain.moniStation.StationType;
import com.flow.service.moniStation.MoniStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 22:32
 */
@Service
public class MoniStationServiceImpl implements MoniStationService {


    @Autowired
    MoniStationDao moniStationDao;

    @Override
    public List<MoniStation> findByAddvcdAndScale(String addvcd, String sttp, String scale) {
        return moniStationDao.findByAddvcdAndScale(addvcd, sttp, scale);
    }

    @Override
    public List<MoniOnline> monitorOnline(String addvcd, String sttp, String scale, String key) {
        return moniStationDao.monitorOnline(addvcd,sttp,scale,key);
    }

    @Override
    public List<StationDetail> getStationDetail(String stcd, String monitorPara) {
        return moniStationDao.getStationDetail(stcd,monitorPara);
    }

    @Override
    public List<StationType> getStationType() {
        return moniStationDao.getMonitorType();
    }
}
