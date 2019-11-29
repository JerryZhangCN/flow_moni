package com.flow.service.moniStation;


import com.flow.domain.moniStation.*;
import com.flow.domain.statistics.PageData;
import com.flow.domain.tools.BaseReturnData;
import com.flow.domain.tools.DataConstants;
import com.flow.domain.video.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 22:31
 */
public interface MoniStationService {

    /**
     * 根据参数获取站点列表
     *
     * @return
     * @RequestParam Addvcd
     * @RequestParam http
     * @RequestParam scale
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
     * @return
     * @RequestParam Addvcd
     * @RequestParam http
     * @RequestParam scale
     * @RequestParam key
     */
    List<MoniOnline> monitorOnline(String Addvcd, String http, String groupId, String key);

    /**
     * 获取站点详细信息
     *
     * @return
     * @RequestParam stcd
     * @RequestParam monitorPara
     */
    List<StationDetail> getStationDetail(String stcd, String monitorPara);

    /**
     * 获取检测站类型
     *
     * @return
     */
    List<StationType> getStationType(String type, String http);


    List<Video> groupStation(String groupId, String key);


    PageData operationStations(String sttp, String groupId, String key, String count, String index);


    StationMsg operationDetail(String stcd);


    List<ConvertMethod> getConvertMethod(String monitorPara);

    List<GB> getGB();

    BaseReturnData createStation(String monitorPara);

    BaseReturnData saveStation(StationMsg stationMsg);
}
