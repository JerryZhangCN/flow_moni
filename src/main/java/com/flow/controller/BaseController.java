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


import com.fasterxml.jackson.databind.ObjectMapper;
import com.flow.dao.mapper.VideoDao;
import com.flow.domain.BaseResponse;
import com.flow.domain.tools.DataConstants;
import com.flow.service.alarm.AlarmService;
import com.flow.service.area.AreaService;
import com.flow.service.curve.CurveService;
import com.flow.service.image.ImageService;
import com.flow.service.moniStation.MoniStationService;
import com.flow.service.scale.ScaleService;
import com.flow.service.statistic.StatisticService;
import com.flow.service.user.UserService;
import com.flow.service.video.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;


/**
 * @author jerry
 * @date 2019-10-06
 */

@Slf4j
public abstract class BaseController {

    public static final String INCORRECT_TENANT_ID = "Incorrect tenantId ";
    public static final String YOU_DON_T_HAVE_PERMISSION_TO_PERFORM_THIS_OPERATION = "You don't have permission to perform this operation!";
    public static final int RESPONSE_OK = 200;
    public static final int RESPONSE_ERROR = 500;

    private static final ObjectMapper json = new ObjectMapper();


    @Autowired
    protected MoniStationService moniStationService;
    @Autowired
    protected AreaService areaService;
    @Autowired
    protected ScaleService scaleService;
    @Autowired
    protected AlarmService alarmService;
    @Autowired
    protected StatisticService statisticService;
    @Autowired
    protected CurveService curveService;
    @Autowired
    protected ImageService imageService;
    @Autowired
    protected VideoService videoService;
    @Autowired
    protected UserService userService;



    protected String constructBaseUrl(HttpServletRequest request) {
        String scheme = request.getScheme();
        if (request.getHeader("x-forwarded-proto") != null) {
            scheme = request.getHeader("x-forwarded-proto");
        }
        int serverPort = request.getServerPort();
        if (request.getHeader("x-forwarded-port") != null) {
            try {
                serverPort = request.getIntHeader("x-forwarded-port");
            } catch (NumberFormatException e) {
            }
        }

        String baseUrl = String.format("%s://%s:%d",
                scheme,
                request.getServerName(),
                serverPort);
        return baseUrl;
    }


    private <T> T extractParameter(Class<T> clazz, int index, Object... additionalInfo) {
        T result = null;
        if (additionalInfo != null && additionalInfo.length > index) {
            Object paramObject = additionalInfo[index];
            if (clazz.isInstance(paramObject)) {
                result = clazz.cast(paramObject);
            }
        }
        return result;
    }

    public BaseResponse returnOk(Object data) {
        return new BaseResponse(RESPONSE_OK, data);
    }

    public BaseResponse returnError(String error) {
        return new BaseResponse(400, error);
    }


}
