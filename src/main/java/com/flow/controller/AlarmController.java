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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
     * 获取行政区域
     *
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse checkUpdates(@Param(DataConstants.MONI_STATION_ADDVCD) String addvcd,
                                     @Param(DataConstants.STATION_STATUS_TYPE) String sttp,
                                     @Param(DataConstants.REQUEST_PARAMS_SCALE) String scale,
                                     @Param(DataConstants.REQUEST_PARAMS_KEYS) String key) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(alarmService.queryAlarm(addvcd,sttp,scale,key));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

}
