package com.flow.service.area;


import com.flow.domain.area.Area;
import com.flow.domain.moniStation.MoniStation;
import com.flow.domain.scale.Group;
import com.flow.domain.statistics.PageData;
import com.flow.domain.tools.BaseReturnData;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 22:31
 */
public interface AreaService {

    List<Area> findAll();

    List<Area> findByAddvcd(String Addvcd);

    List<Group> findGroup(String group);

    PageData getAreaByAddvcd(String addvcd, String key, String count, String index);


    BaseReturnData createArea(String addvcd);

    BaseReturnData saveArea(Area area);
}
