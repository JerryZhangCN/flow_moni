package com.flow.controller;

import com.alibaba.fastjson.JSONObject;
import com.flow.domain.BaseResponse;
import com.flow.domain.curve.Curve;
import com.flow.domain.statistics.CurveData;
import com.flow.domain.statistics.FloatWindowData;
import com.flow.domain.tools.DataConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
     * 获取首页下的单站曲线数据
     *
     * @return
     */
    @RequestMapping(value = "/curveData", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse checkUpdates(@RequestParam(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                     @RequestParam(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara) {
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


    /**
     * 获取生态流量曲线数据
     *
     * @return
     */
    @RequestMapping(value = "/flowData", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse SLData(@Nullable String stcd,
                               @Nullable String monitorPara,
                               @Nullable String startTime,
                               @Nullable String endTime) {
        try {
            if (StringUtils.isBlank(stcd) || StringUtils.isBlank(monitorPara)) {
                return returnError(DataConstants.RESPONSE_PARAM_ERROR);
            }
            startTime=startTime.replace("-","/");
            endTime=endTime.replace("-","/");
            Curve curveData = curveService.findFlowData(stcd, monitorPara,startTime,endTime);
            return returnOk(curveData);
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 获取生态流量浮窗数据
     *
     * @return
     */
    @RequestMapping(value = "/flowFloat", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse SLFloatData(@Nullable String stcd,
                               @Nullable String monitorPara,
                               @Nullable String startTime,
                               @Nullable String endTime) {
        try {
            if (StringUtils.isBlank(stcd) || StringUtils.isBlank(monitorPara)) {
                return returnError(DataConstants.RESPONSE_PARAM_ERROR);
            }
            startTime=startTime.replace("-","/");
            endTime=endTime.replace("-","/");
            FloatWindowData floatWindowData = curveService.flowFloatData(stcd, monitorPara,startTime,endTime);
            return returnOk(floatWindowData);
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 获取取水计量曲线数据
     *
     * @return
     */
    @RequestMapping(value = "/waterData", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse waterData(@RequestParam(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                               @RequestParam(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara,
                               @RequestParam(DataConstants.REQUEST_PARAMS_START) String start,
                               @RequestParam(DataConstants.REQUEST_PARAMS_END) String end) {
        try {
            if (StringUtils.isBlank(stcd) || StringUtils.isBlank(monitorPara)) {
                return returnError(DataConstants.RESPONSE_PARAM_ERROR);
            }
            start=start.replace("-","/");
            end=end.replace("-","/");
            Curve curveData = curveService.findWaterData(stcd, monitorPara,start,end);
            return returnOk(curveData);
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 获取生态流量浮窗数据
     *
     * @return
     */
    @RequestMapping(value = "/waterFloat", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse waterFloatData(@Nullable String stcd,
                                    @Nullable String monitorPara,
                                    @Nullable String startTime,
                                    @Nullable String endTime) {
        try {
            if (StringUtils.isBlank(stcd) || StringUtils.isBlank(monitorPara)) {
                return returnError(DataConstants.RESPONSE_PARAM_ERROR);
            }
            startTime=startTime.replace("-","/");
            endTime=endTime.replace("-","/");
            FloatWindowData floatWindowData = curveService.waterFloatData(stcd, monitorPara,startTime,endTime);
            return returnOk(floatWindowData);
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 获取取水计量曲线数据
     *
     * @return
     */
    @RequestMapping(value = "/qualityData", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse qualityData(@RequestParam(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                  @RequestParam(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara,
                                  @RequestParam(DataConstants.REQUEST_PARAMS_START) String start,
                                  @RequestParam(DataConstants.REQUEST_PARAMS_END) String end) {
        try {
            if (StringUtils.isBlank(stcd) || StringUtils.isBlank(monitorPara)) {
                return returnError(DataConstants.RESPONSE_PARAM_ERROR);
            }
            start=start.replace("-","/");
            end=end.replace("-","/");
            Curve curveData = curveService.findQualityData(stcd, monitorPara,start,end);
            return returnOk(curveData);
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 获取生态流量浮窗数据
     *
     * @return
     */
    @RequestMapping(value = "/qualityFloat", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse qualityFloatData(@Nullable String stcd,
                                       @Nullable String monitorPara,
                                       @Nullable String startTime,
                                       @Nullable String endTime) {
        try {
            if (StringUtils.isBlank(stcd) || StringUtils.isBlank(monitorPara)) {
                return returnError(DataConstants.RESPONSE_PARAM_ERROR);
            }
            startTime=startTime.replace("-","/");
            endTime=endTime.replace("-","/");
            FloatWindowData floatWindowData = curveService.qualityFloatData(stcd, monitorPara,startTime,endTime);
            return returnOk(floatWindowData);
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

}
