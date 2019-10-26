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
import com.flow.domain.area.Area;
import com.flow.domain.tools.DataConstants;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * @author jerry
 * @date 2019-10-08
 */
@RestController
@RequestMapping("/api/alarm")
public class AlarmController extends BaseController {


    /**
     * 获取报警信息
     *
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse checkUpdates(@Nullable String addvcd,
                                     @Nullable String sttp,
                                     @Nullable String groupId,
                                     @Nullable String key) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(alarmService.queryAlarmByGroupId(addvcd, sttp, groupId, key));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 获取报警设置信息
     *
     * @return
     */
    @RequestMapping(value = "/alarmSetting", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse alarmSetting(@Nullable String sttp,
                                     @Nullable String groupId,
                                     @Nullable String key,
                                     @Nullable String count,
                                     @Nullable String index) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(alarmService.getAlarmSetting(sttp, groupId, key, count, index));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 获取报警设置信息
     *
     * @return
     */
    @RequestMapping(value = "/settingDetail", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse settingDatail(@Nullable String stcd,
                                      @Nullable String monitorPara,
                                      @Nullable String alarmInterval) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(alarmService.settingDetail(stcd, monitorPara, alarmInterval));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 获取报警设置信息
     *
     * @return
     */
    @RequestMapping(value = "/getAlarmInterval", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse alarmInterval() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(alarmService.getAlarmInterval());
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 获取报警设置信息
     *
     * @return
     */
    @RequestMapping(value = "/getAlarmMethod", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse alarmMethod() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(alarmService.getAlarmMethod());
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 创建报警阈值
     *
     * @return
     */
    @RequestMapping(value = "/createAlarm", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse createAlarm(@Nullable String stcd) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(alarmService.createAlarm(stcd));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 保存报警阈值
     *
     * @return
     */
    @RequestMapping(value = "/saveAlarm", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse saveAlarm(@Nullable String stcd,
                                  @Nullable String beforeMonitorPara,
                                  @Nullable String beforeAlarmInterval,
                                  @Nullable String monitorPara,
                                  @Nullable String alarmInterval,
                                  @Nullable String compareType,
                                  @Nullable String oneLevelAlarmValue,
                                  @Nullable String twoLevelAlarmValue,
                                  @Nullable String alarmMethod,
                                  @Nullable String alarmForm) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(alarmService.saveAlarm(stcd, beforeMonitorPara, beforeAlarmInterval, monitorPara, alarmInterval, compareType, oneLevelAlarmValue, twoLevelAlarmValue, alarmMethod, alarmForm));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 获取报警设置信息
     *
     * @return
     */
    @RequestMapping(value = "/alarmHistory", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse alarmHistory(@Nullable String sttp,
                                     @Nullable String groupId,
                                     @Nullable String key,
                                     @Nullable String count,
                                     @Nullable String index) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(alarmService.getAlarmHistory(sttp, groupId, key, count, index));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }
}
