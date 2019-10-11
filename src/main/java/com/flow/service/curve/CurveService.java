package com.flow.service.curve;

import com.flow.domain.statistics.CurveData;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-11 10:07
 */
public interface CurveService {

    List<CurveData> findByStcdAndPara(String stcd, String monitorPara);
}
