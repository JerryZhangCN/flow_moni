/**
 * Copyright © 2016-2019 The Thingsboard Authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.flow.controller;

import com.flow.domain.BaseResponse;
import com.flow.domain.tools.DataConstants;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;


/**
 * @author jerry
 * @date 2019-10-08
 */
@RestController
@RequestMapping("/api/statistics")
public class StatisticController extends BaseController {


    /**
     * 获取首页实时统计
     *
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getScale(@RequestParam(DataConstants.STATION_STATUS_TYPE) String sttp,
                                 @RequestParam(DataConstants.REQUEST_PARAMS_GROUP_ID) String groupId) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(statisticService.query(sttp, groupId));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 获取生态流量查询统计
     *
     * @return
     */
    @RequestMapping(value = "/getFlow", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getFlowData(@RequestParam("type") String type,
                                    @RequestParam(DataConstants.MONI_STATION_ADDVCD) String addvcd,
                                    @RequestParam(DataConstants.REQUEST_PARAMS_SCALE) String scale,
                                    @RequestParam(DataConstants.REQUEST_PARAMS_START) String start,
                                    @RequestParam(DataConstants.REQUEST_PARAMS_END) String end,
                                    @RequestParam(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                    @RequestParam(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                    @RequestParam(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index,
                                    @RequestParam(DataConstants.REQUEST_PARAMS_ALARM_LEVEL) String level,
                                    @RequestParam(DataConstants.REQUEST_PARAMS_TIME_SCALE) String timeScale) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(statisticService.getFlowData(type, addvcd, scale, start, end, key, count, index, level, timeScale));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 获取单站统计
     *
     * @return
     */
    @RequestMapping(value = "/stationData", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse monthData(@RequestParam(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                  @RequestParam(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara,
                                  @RequestParam(DataConstants.REQUEST_PARAMS_TIME_TYPE) String timeType) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(statisticService.stationStatistics(timeType, stcd, monitorPara));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 获取视频在线统计
     *
     * @return
     */
    @RequestMapping(value = "/videoData", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse video(@RequestParam(DataConstants.STATION_STATUS_TYPE) String sttp,
                              @RequestParam(DataConstants.REQUEST_PARAMS_GROUP_ID) String groupId) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(statisticService.videoStatistics(sttp, groupId));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 获取取水计量查询统计
     *
     * @return
     */
    @RequestMapping(value = "/getUseFlowData", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getUseFlowData(@RequestParam(DataConstants.MONI_STATION_ADDVCD) String addvcd,
                                       @RequestParam(DataConstants.STATION_STATUS_TYPE) String sttp,
                                       @RequestParam(DataConstants.REQUEST_PARAMS_START) String start,
                                       @RequestParam(DataConstants.REQUEST_PARAMS_END) String end,
                                       @RequestParam(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                       @RequestParam(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                       @RequestParam(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index,
                                       @RequestParam(DataConstants.REQUEST_PARAMS_ALARM_LEVEL) String level,
                                       @RequestParam(DataConstants.REQUEST_PARAMS_TIME_SCALE) String timeScale) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(statisticService.getUseFlowData(addvcd, sttp, start, end, key, count, index, level, timeScale));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 获取河湖水质数据
     *
     * @return
     */
    @RequestMapping(value = "/getWaterQuality", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getWaterQuality(@RequestParam(DataConstants.MONI_STATION_ADDVCD) String addvcd,
                                        @RequestParam(DataConstants.REQUEST_PARAMS_QUALITY_LEVEL) String qualityLevel,
                                        @RequestParam(DataConstants.REQUEST_PARAMS_START) String start,
                                        @RequestParam(DataConstants.REQUEST_PARAMS_END) String end,
                                        @RequestParam(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                        @RequestParam(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                        @RequestParam(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index,
                                        @RequestParam(DataConstants.REQUEST_PARAMS_ALARM_LEVEL) String level,
                                        @RequestParam(value = DataConstants.REQUEST_PARAMS_MONITOR_TYPE, required = false) String monitorType) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(statisticService.getWaterQuality(addvcd, qualityLevel, start, end, key, count, index, level, monitorType));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 获取河湖水质级别
     *
     * @return
     */
    @RequestMapping(value = "/getQualityLevel", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getQualityLevel() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(statisticService.getQualityLevel());
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 获取河湖水质监测指标
     *
     * @return
     */
    @RequestMapping(value = "/getMonitorPara", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getMonitorPara(@Nullable String sttp) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(statisticService.getMotorPara(sttp));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

}
