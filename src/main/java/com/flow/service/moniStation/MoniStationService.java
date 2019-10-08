package com.flow.service.moniStation;


import com.flow.domain.moniStation.MoniStation;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 22:31
 */
public interface MoniStationService {

    List<MoniStation> findAll();

    List<MoniStation> findByAddvcd(String Addvcd);
}
