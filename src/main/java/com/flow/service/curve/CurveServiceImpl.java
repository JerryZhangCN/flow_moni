package com.flow.service.curve;

import com.alibaba.fastjson.JSONObject;
import com.flow.dao.mapper.CurveDao;
import com.flow.domain.curve.Curve;
import com.flow.domain.scale.CurveProperty;
import com.flow.domain.statistics.CurveData;
import com.flow.domain.statistics.FloatWindowData;
import com.flow.domain.statistics.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.table.TableRowSorter;
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

    @Override
    public Curve findFlowData(String stcd, String monitorPara, String start, String end) {
        try {
            List<List<Object>> ob = curveDao.findFlowData(stcd, monitorPara, start, end);
            if(ob!=null&&ob.size()>0){
                CurveProperty curveProperty = (CurveProperty) ob.get(1).get(0);
                CurveData curveData =(CurveData) (ob.get(0).get(0));
                curveProperty.setAlarmValue(curveData.getAlarmValue());
                Curve curve = new Curve(ob.get(0), curveProperty);
                return curve;
            }
        }catch (Exception e){
            return null;
        }
        return null;

    }

    @Override
    public Curve findWaterData(String stcd, String monitorPara, String start, String end) {
        try {
            List<List<Object>> ob = curveDao.findWaterData(stcd, monitorPara, start, end);
            if(ob!=null&&ob.size()>0){
                CurveProperty curveProperty = (CurveProperty) ob.get(1).get(0);
                Curve curve = new Curve(ob.get(0), curveProperty);
                return curve;
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }

    @Override
    public Curve findQualityData(String stcd, String monitorPara, String start, String end) {
        try {
            List<List<Object>> ob = curveDao.findQualityData(stcd, monitorPara, start, end);
            if(ob!=null&&ob.size()>0){
                CurveProperty curveProperty = (CurveProperty) ob.get(1).get(0);
                Curve curve = new Curve(ob.get(0), curveProperty);
                return curve;
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }

    @Override
    public FloatWindowData flowFloatData(String stcd, String monitorPara, String start, String end) {
        return curveDao.flowFloatData(stcd, monitorPara, start, end);
    }

    @Override
    public FloatWindowData waterFloatData(String stcd, String monitorPara, String start, String end) {
        return curveDao.waterFloatData(stcd,monitorPara,start,end);
    }

    @Override
    public FloatWindowData qualityFloatData(String stcd, String monitorPara, String start, String end) {
        return curveDao.qualityFloatData(stcd, monitorPara, start, end);
    }
}
