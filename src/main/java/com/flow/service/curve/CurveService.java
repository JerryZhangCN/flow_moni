package com.flow.service.curve;

import com.flow.domain.curve.Curve;
import com.flow.domain.statistics.CurveData;
import com.flow.domain.statistics.FloatWindowData;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-11 10:07
 */
public interface CurveService {

    List<CurveData> findByStcdAndPara(String stcd, String monitorPara);

    Curve findFlowData(String stcd, String monitorPara, String start, String end);

    Curve findWaterData(String stcd, String monitorPara, String start, String end);

    Curve findQualityData(String stcd, String monitorPara, String start, String end);

    FloatWindowData flowFloatData(String stcd, String monitorPara, String start, String end);

    FloatWindowData waterFloatData(String stcd, String monitorPara, String start, String end);

    FloatWindowData qualityFloatData(String stcd, String monitorPara, String start, String end);

}
