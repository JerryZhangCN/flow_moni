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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author jerry
 * @date 2019-10-08
 */
@RestController
@RequestMapping("/api/statistics")
public class StatisticController extends BaseController {


    /**
     * 获取实时统计
     *
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getScale(@Param(DataConstants.STATION_STATUS_TYPE) String sttp,
                                 @Param(DataConstants.REQUEST_PARAMS_GROUP_ID) String groupId) {
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
    public BaseResponse getFlowData(@Param(DataConstants.MONI_STATION_ADDVCD) String addvcd,
                                    @Param(DataConstants.REQUEST_PARAMS_SCALE) String scale,
                                    @Param(DataConstants.REQUEST_PARAMS_START) String start,
                                    @Param(DataConstants.REQUEST_PARAMS_END) String end,
                                    @Param(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                    @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                    @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index,
                                    @Param(DataConstants.REQUEST_PARAMS_ALARM_LEVEL) String level,
                                    @Param(DataConstants.REQUEST_PARAMS_TIME_SCALE) String timeScale) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(statisticService.getFlowData(addvcd, scale, start, end, key, count, index, level, timeScale));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }
}
