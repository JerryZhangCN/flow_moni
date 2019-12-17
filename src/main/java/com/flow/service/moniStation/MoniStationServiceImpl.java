package com.flow.service.moniStation;


import com.flow.dao.mapper.MoniStationDao;
import com.flow.domain.moniStation.*;
import com.flow.domain.statistics.PageData;
import com.flow.domain.tools.BaseReturnData;
import com.flow.domain.tools.DataConstants;
import com.flow.domain.video.Video;
import org.apache.ibatis.annotations.Param;
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
    public List<MoniStation> findByGroupId(String sttp, String groupId) {
        return moniStationDao.findByGroupId(groupId, sttp);

    }

    @Override
    public List<MoniOnline> monitorOnline(String addvcd, String sttp, String groupId, String key) {
        return moniStationDao.monitorOnline(addvcd, sttp, groupId, key);
    }

    @Override
    public List<StationDetail> getStationDetail(String stcd, String monitorPara) {
        return moniStationDao.getStationDetail(stcd, monitorPara);
    }

    @Override
    public List<StationType> getStationType(String type, String sttp) {
        return moniStationDao.getMonitorType(type, sttp);
    }

    @Override
    public List<Video> groupStation(String groupId, String key) {
        return moniStationDao.groupStation(groupId, key);
    }

    @Override
    public PageData operationStations(String sttp, String groupId, String key, String count, String index) {
        List<List<Object>> ob = moniStationDao.operationStations(sttp, groupId, key, count, index);
        return new PageData(ob.get(0), ob.get(1).get(0).toString());
    }

    @Override
    public StationMsg operationDetail(String stcd) {
        return moniStationDao.operationDetail(stcd);
    }

    @Override
    public List<ConvertMethod> getConvertMethod(String monitorPara) {
        return moniStationDao.getConvertMethod(monitorPara);
    }

    @Override
    public List<GB> getGB() {
        return moniStationDao.getGB();
    }

    @Override
    public BaseReturnData createStation(String monitorPara) {
        return (BaseReturnData) moniStationDao.createStation(monitorPara).get(1).get(0);
    }

    @Override
    public BaseReturnData saveStation(StationMsg stationMsg) {
        return moniStationDao.saveStation(stationMsg);
    }

    @Override
    public List<StationType> getHomeType() {
        return moniStationDao.getHomeType();
    }

    @Override
    public HomeStationDetail homeStationDetail(String stcd) {
        return moniStationDao.homeStationDetail(stcd);
    }

    @Override
    public List<StationStatus> stationStatus(String sttp) {
        return moniStationDao.stationStatus(sttp);
    }

    @Override
    public List<BaseBoxData> stationScaleType() {
        return moniStationDao.stationScaleType();
    }

    @Override
    public List<BaseBoxData> stationType() {
        return moniStationDao.stationType();
    }

    @Override
    public List<BaseBoxData> stationSon(String sttp) {
        return moniStationDao.stationSon(sttp);
    }

    @Override
    public List<BaseBoxData> stationScale(String sttp, String scaleType) {
        return moniStationDao.stationScale(sttp, scaleType);
    }

    @Override
    public List<BaseBoxData> gbLevel() {
        return moniStationDao.gbLevel();
    }
}
