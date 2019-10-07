/**
 * Copyright © 2016-2019 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.flow.controller;

import com.flow.domain.BaseResponse;
import com.flow.service.moniStation.MoniStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author jerry
 * @date 2019-10-06
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {

    @Autowired
    private MoniStationService moniStationService;



    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse checkUpdates() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResultCode(200);
        baseResponse.setData(moniStationService.findAll());
        return baseResponse;
    }

}
