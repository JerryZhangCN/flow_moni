package com.flow.service.area;


import com.flow.domain.area.Area;
import com.flow.domain.moniStation.MoniStation;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 22:31
 */
public interface AreaService {

    List<Area> findAll();

    List<Area> findByAddvcd(String Addvcd);
}
