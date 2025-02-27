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
import org.springframework.web.bind.annotation.*;

/**
 * @author jerry
 * @date 2019-10-08
 */
@RestController
@RequestMapping("/api/scale")
public class ScaleController extends BaseController {


    /**
     * 获取规模列表
     *
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getScale(@RequestParam(DataConstants.STATION_STATUS_TYPE) String sttp,
                                 @RequestParam(DataConstants.REQUEST_PARAMS_TYPE) String type) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(scaleService.findByType(sttp, type));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 获取规模列表
     *
     * @return
     */
    @RequestMapping(value = "/getGroup", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getScale(@RequestParam(DataConstants.STATION_STATUS_TYPE) String sttp) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(scaleService.getGroup(sttp));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

}
