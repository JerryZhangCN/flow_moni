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
import com.flow.domain.moniStation.MoniStation;
import com.flow.domain.moniStation.StationMsg;
import com.flow.domain.moniStation.StationType;
import com.flow.domain.scale.Scale;
import com.flow.domain.tools.DataConstants;
import com.flow.service.moniStation.MoniStationService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

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


    /**
     * 根据行政区划获取监测站点信息（若不传递，则默认获取所有站点信息）
     *
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getMoniStation(@RequestParam(DataConstants.STATION_STATUS_TYPE) String sttp,
                                       @RequestParam(DataConstants.REQUEST_PARAMS_GROUP_ID) String groupId) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            List<MoniStation> list = moniStationService.findByGroupId(sttp, groupId);
            list.forEach(l -> {
                if (l.getIcoPosition() != null && !l.getIcoPosition().equalsIgnoreCase("")) {
                    l.setIcoPosition(DataConstants.BASE_ICON_IP + l.getIcoPosition());
                }
                if (l.getFlickerIcoPosition() != null && !l.getFlickerIcoPosition().equalsIgnoreCase("")) {
                    l.setFlickerIcoPosition(DataConstants.BASE_ICON_IP + l.getFlickerIcoPosition());
                }

            });
            baseResponse.setData(list);
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
    public BaseResponse stationDetail(@RequestParam(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                      @RequestParam(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String monitorPara) {
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
    public BaseResponse monitorOnline(@Nullable String type,
                                      @Nullable String sttp) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            List<StationType> types = moniStationService.getStationType(type, sttp);
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
     * 获取检测站类型
     *
     * @return
     */
    @RequestMapping(value = "/homeType", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse homeType() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            List<StationType> types = moniStationService.getHomeType();
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
    public BaseResponse moniOnline(@RequestParam(DataConstants.MONI_STATION_ADDVCD) String addvcd,
                                   @RequestParam(DataConstants.STATION_STATUS_TYPE) String sttp,
                                   @RequestParam(DataConstants.REQUEST_PARAMS_GROUP_ID) String groupId,
                                   @RequestParam(DataConstants.REQUEST_PARAMS_KEYS) String key) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.monitorOnline(addvcd, sttp, groupId, key));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 根据视频分组获取站点信息
     *
     * @return
     */
    @RequestMapping(value = "/groupStation", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse moniOnline(@Nullable String groupId,
                                   @Nullable String key) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.groupStation(groupId, key));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 平台运维根据测站类别和分组进行获取测站列表
     *
     * @return
     */
    @RequestMapping(value = "/operationStations", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse operationStations(@Nullable String sttp,
                                          @Nullable String groupId,
                                          @Nullable String key,
                                          @Nullable String count,
                                          @Nullable String index) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.operationStations(sttp, groupId, key, count, index));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 首页-视频监控-测站详情
     *
     * @return
     */
    @RequestMapping(value = "/homeStationDetail", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse homeStationDetail(@Nullable String stcd) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.homeStationDetail(stcd));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 测站管理-测站详情
     *
     * @return
     */
    @RequestMapping(value = "/operationDetail", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse operationDetail(@Nullable String stcd) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.operationDetail(stcd));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 测站管理-转换方式
     *
     * @return
     */
    @RequestMapping(value = "/convertMethod", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse convertMethod(@Nullable String monitorPara) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.getConvertMethod(monitorPara));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 测站管理-国标
     *
     * @return
     */
    @RequestMapping(value = "/gb", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse gb() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.getGB());
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 测站管理-创建测站
     *
     * @return
     */
    @RequestMapping(value = "/createStation", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse createStation(@Nullable String monitorPara) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.createStation(monitorPara));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 测站管理-编辑测站信息
     *
     * @return
     */
    @RequestMapping(value = "/saveStation", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse saveStation(@RequestBody StationMsg stationMsg) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.saveStation(stationMsg));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 测站管理-测站状态
     *
     * @return
     */
    @RequestMapping(value = "/stationStatus", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse stationStatus(@Nullable String sttp) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.stationStatus(sttp));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 测站管理-规模类别
     *
     * @return
     */
    @RequestMapping(value = "/stationScaleType", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse scaleType() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.stationScaleType());
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 测站管理-测站类别
     *
     * @return
     */
    @RequestMapping(value = "/stationType", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse stationType() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.stationType());
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 测站管理-测站规模
     *
     * @return
     */
    @RequestMapping(value = "/stationScale", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse stationScale(@Nullable String sttp,
                                     @Nullable String scaleType) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.stationScale(sttp, scaleType));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 测站管理-测站子列
     *
     * @return
     */
    @RequestMapping(value = "/stationSon", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse stationSon(@Nullable String sttp) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.stationSon(sttp));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 测站管理-国标级别
     *
     * @return
     */
    @RequestMapping(value = "/gbLevel", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse gbLevel() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            baseResponse.setData(moniStationService.gbLevel());
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


}
