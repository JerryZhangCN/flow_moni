package com.flow.service.curve;

import com.flow.dao.mapper.CurveDao;
import com.flow.domain.statistics.CurveData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-11 10:08
 */
@Service
public class CurveServiceImpl implements CurveService {

    @Autowired
    private CurveDao curveDao;

    @Override
    public List<CurveData> findByStcdAndPara(String stcd, String monitorPara) {
        return curveDao.findByStcdAndPara(stcd, monitorPara);
    }
}
