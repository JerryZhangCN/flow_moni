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
     * @RequestParam Addvcd
     * @RequestParam http
     * @RequestParam scale
     * @return
     */
    List<MoniStation> findByAddvcdAndScale(String Addvcd, String http, String scale);
    /**
     * 根据参数获取站点列表
     *
     * @return
     */
    List<MoniStation> findByGroupId(String sttp, String groupId);

    /**
     * 获取实时监测
     *
     * @RequestParam Addvcd
     * @RequestParam http
     * @RequestParam scale
     * @RequestParam key
     * @return
     */
    List<MoniOnline> monitorOnline(String Addvcd, String http, String groupId, String key);

    /**
     * 获取站点详细信息
     *
     * @RequestParam stcd
     * @RequestParam monitorPara
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
