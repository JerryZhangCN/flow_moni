package com.flow.controller;

import com.alibaba.fastjson.JSONObject;
import com.flow.domain.BaseResponse;
import com.flow.domain.statistics.CurveData;
import com.flow.domain.tools.DataConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.geom.CubicCurve2D;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author jerry
 * @date 2019-10-11 10:03
 */
@RestController
@RequestMapping("api/curve")
public class CurveDataController extends BaseController {


    /**
     * 获取行政区域
     *
     * @return
     */
    @RequestMapping(value = "/curveData", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse checkUpdates(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                     @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara) {
        try {
            if (StringUtils.isBlank(stcd) || StringUtils.isBlank(monitorPara)) {
                return returnError(DataConstants.RESPONSE_PARAM_ERROR);
            }
            List<CurveData> curveDataList = curveService.findByStcdAndPara(stcd, monitorPara);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(DataConstants.RESPONSE_PARAMS_DATA, curveDataList);
            jsonObject.put(DataConstants.REQUEST_PARAMS_ALARM_VALUE, curveDataList.get(0).getAlarmValue());
            return returnOk(jsonObject);
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

}
