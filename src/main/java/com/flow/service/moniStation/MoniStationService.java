package com.flow.service.moniStation;


import com.flow.domain.moniStation.MoniOnline;
import com.flow.domain.moniStation.MoniStation;
import com.flow.domain.moniStation.StationDetail;
import com.flow.domain.moniStation.StationType;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 22:31
 */
public interface MoniStationService {

    /**
     * 根据参数获取站点列表
     *
     * @param Addvcd
     * @param http
     * @param scale
     * @return
     */
    List<MoniStation> findByAddvcdAndScale(String Addvcd, String http, String scale);

    /**
     * 获取实时监测
     *
     * @param Addvcd
     * @param http
     * @param scale
     * @param key
     * @return
     */
    List<MoniOnline> monitorOnline(String Addvcd, String http, String scale, String key);

    /**
     * 获取站点详细信息
     *
     * @param stcd
     * @param monitorPara
     * @return
     */
    List<StationDetail> getStationDetail(String stcd, String monitorPara);

    /**
     * 获取检测站类型
     *
     * @return
     */
    List<StationType> getStationType();
}
