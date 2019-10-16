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
import com.flow.domain.moniStation.StationType;
import com.flow.domain.scale.Scale;
import com.flow.domain.tools.DataConstants;
import com.flow.service.moniStation.MoniStationService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * @author jerry
 * @date 2019-10-08
 */
@RestController
@RequestMapping("/api/moni_station")
public class MoniStationController extends BaseController {

    @Autowired
    private MoniStationService moniStationService;


//    /**
//     * 根据行政区划获取监测站点信息（若不传递，则默认获取所有站点信息）
//     *
//     * @return
//     */
//    @RequestMapping(value = "/query", method = RequestMethod.GET)
//    @ResponseBody
//    public BaseResponse getMoniStation(@Param(DataConstants.MONI_STATION_ADDVCD) String addvcd,
//                                       @Param(DataConstants.STATION_STATUS_TYPE) String sttp,
//                                       @Param(DataConstants.STATION_STATUS_TYPE) String scale) {
//        BaseResponse baseResponse = new BaseResponse();
//        try {
//            baseResponse.setResultCode(RESPONSE_OK);
//            baseResponse.setData(moniStationService.findByAddvcdAndScale(addvcd, sttp, scale));
//            return baseResponse;
//        } catch (Exception e) {
//            return returnError(e.getMessage());
//        }
//    }

    /**
     * 根据行政区划获取监测站点信息（若不传递，则默认获取所有站点信息）
     *
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getMoniStation(@Param(DataConstants.STATION_STATUS_TYPE) String sttp,
                                       @Param(DataConstants.REQUEST_PARAMS_GROUP_ID) String groupId) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.findByGroupId(sttp, groupId));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 根据测站编码获取检测站详情（若不传递，则默认获取所有站点信息）
     *
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse stationDetail(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                      @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.getStationDetail(stcd, monitorPara));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 获取检测站类型
     *
     * @return
     */
    @RequestMapping(value = "/monitorType", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse monitorOnline() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            List<StationType> types = moniStationService.getStationType();
            List<Scale> scales = scaleService.findByType(null, null);
            for (StationType stationType : types) {
                for (Scale scale : scales) {
                    if (scale.getSttp().equalsIgnoreCase(stationType.getSttp())) {
                        stationType.getScales().add(scale);
                    }
                }
            }
            baseResponse.setData(types);
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 根据行政区划获取监测站点信息（若不传递，则默认获取所有站点信息）
     *
     * @return
     */
    @RequestMapping(value = "/moniOnline", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse moniOnline(@Param(DataConstants.MONI_STATION_ADDVCD) String addvcd,
                                   @Param(DataConstants.STATION_STATUS_TYPE) String sttp,
                                   @Param(DataConstants.REQUEST_PARAMS_GROUP_ID) String groupId,
                                   @Param(DataConstants.REQUEST_PARAMS_KEYS) String key) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.monitorOnline(addvcd, sttp, groupId, key));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

}
