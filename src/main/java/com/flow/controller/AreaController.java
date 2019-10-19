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
import com.flow.domain.scale.Group;
import com.flow.domain.tools.DataConstants;
import com.flow.service.moniStation.MoniStationService;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * @author jerry
 * @date 2019-10-08
 */
@RestController
@RequestMapping("/api/area")
public class AreaController extends BaseController {


    /**
     * 获取行政区域
     *
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse checkUpdates() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<Area> result = areaService.findAll();
            Map<String, Area> areaMap = new LinkedHashMap<>();
            for (Area a : result) {
                if (areaMap.containsKey(a.getPAddvcd())) {
                    areaMap.get(a.getPAddvcd()).getChildren().add(a);
                } else if (!a.getLevel().equalsIgnoreCase("4")) {
                    areaMap.put(a.getAddvcd(), a);
                }
            }
            baseResponse.setData(areaMap.values());
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 获取行政区域
     *
     * @return
     */
    @RequestMapping(value = "/group", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse group(@RequestParam(DataConstants.STATION_STATUS_TYPE) String sttp) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<Group> result = areaService.findGroup(sttp);
            Map<String, Group> areaMap = new LinkedHashMap<>();
            for (Group group : result) {
                if (group.getPGroupId()==null||group.getPGroupId()==""||group.getPGroupId().length()==0){
                    areaMap.put(group.getGroupId(), group);
                }else if(areaMap.containsKey(group.getPGroupId())){
                    areaMap.get(group.getPGroupId()).getGroups().add(group);
                }
            }
            baseResponse.setData(areaMap.values());
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

}
