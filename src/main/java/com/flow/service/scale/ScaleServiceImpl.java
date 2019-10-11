package com.flow.service.scale;


import com.flow.dao.mapper.AreaDao;
import com.flow.dao.mapper.ScaleDao;
import com.flow.domain.area.Area;
import com.flow.domain.scale.Scale;
import com.flow.service.area.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 22:32
 */
@Service
public class ScaleServiceImpl implements ScaleService {


    @Autowired
    ScaleDao scaleDao;

    @Override
    public List<Scale> findByType(String sttp, String type) {
        return scaleDao.findByType(sttp,type);
    }
}
