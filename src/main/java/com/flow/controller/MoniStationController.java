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
import com.flow.service.moniStation.MoniStationService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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
    public BaseResponse checkUpdates(@Param(DataConstants.MONI_STATION_ADDVCD) String addvcd) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(RESPONSE_OK);
            if (StringUtils.isEmpty(addvcd)) {
                baseResponse.setData(moniStationService.findAll());
            } else {
                baseResponse.setData(moniStationService.findByAddvcd(addvcd));
            }
            return baseResponse;
        } catch (Exception e) {
            return returnError();
        }
    }

}
