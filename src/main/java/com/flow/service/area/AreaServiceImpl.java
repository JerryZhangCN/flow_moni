package com.flow.service.area;


import com.flow.dao.mapper.AreaDao;
import com.flow.dao.mapper.MoniStationDao;
import com.flow.domain.area.Area;
import com.flow.domain.moniStation.MoniStation;
import com.flow.service.moniStation.MoniStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 22:32
 */
@Service
public class AreaServiceImpl implements AreaService {


    @Autowired
    AreaDao areaDao;


    @Override
    public List<Area> findAll() {
        return areaDao.queryAll();
    }

    @Override
    public List<Area> findByAddvcd(String addvcd) {
        return areaDao.findByAddvcd(addvcd);
    }
}
