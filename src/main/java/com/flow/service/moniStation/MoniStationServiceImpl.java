package com.flow.service.moniStation;


import com.flow.dao.mapper.MoniStationDao;
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
public class MoniStationServiceImpl implements MoniStationService {


    @Autowired
    MoniStationDao moniStationDao;


    @Override
    public List<MoniStation> findAll() {
        return moniStationDao.queryAll();
    }

    @Override
    public List<MoniStation> findByAddvcd(String addvcd) {
        return moniStationDao.findByAddvcd(addvcd);
    }
}
