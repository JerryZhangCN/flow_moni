package com.flow.service.area;


import com.flow.dao.mapper.AreaDao;
import com.flow.dao.mapper.MoniStationDao;
import com.flow.domain.area.Area;
import com.flow.domain.moniStation.MoniStation;
import com.flow.domain.scale.Group;
import com.flow.domain.statistics.PageData;
import com.flow.domain.tools.BaseReturnData;
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

    @Override
    public List<Group> findGroup(String group) {
        return areaDao.getGroup(group);
    }

    @Override
    public PageData getAreaByAddvcd(String addvcd, String key, String count, String index) {
        List<List<Object>> ob=areaDao.getAreaByAddvcd(addvcd, key, count, index);
        return new PageData(ob.get(0), ob.get(1).get(0).toString());
    }

    @Override
    public BaseReturnData createArea(String addvcd) {
        List<List<Object>> ob  = areaDao.createArea(addvcd);
        return (BaseReturnData) ob.get(1).get(0);
    }

    @Override
    public BaseReturnData saveArea(Area area) {
        return areaDao.saveArea(area);
    }
}
