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
import com.flow.domain.user.ContactUser;
import com.flow.service.moniStation.MoniStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;


/**
 * @author jerry
 * @date 2019-10-06
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {

    /**
     * 获取报警关联
     *
     * @return
     */
    @RequestMapping(value = "/getContactUser", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse settingDatail(@Nullable String stcd,
                                      @Nullable String organizationId,
                                      @Nullable String key,
                                      @Nullable String selectType,
                                      @Nullable String count,
                                      @Nullable String index) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(userService.getContactUser(stcd, selectType, organizationId, key, count, index));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 获取报警关联
     *
     * @return
     */
    @RequestMapping(value = "/getOrganization", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse organization(@Nullable String stcd,
                                     @Nullable String count,
                                     @Nullable String index) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(200);
            baseResponse.setData(userService.getOrganization(stcd, count, index));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 报警关联联系人
     *
     * @return
     */
    @RequestMapping(value = "/associate", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse associate(@Nullable String stcd,
                                  @Nullable String organizationId,
                                  @Nullable String addressBookId) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(200);
            baseResponse.setData(userService.associateUser(stcd, organizationId, addressBookId));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 报警取消关联联系人
     *
     * @return
     */
    @RequestMapping(value = "/associateCancel", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse associateCancel(@Nullable String stcd,
                                        @Nullable String organizationId,
                                        @Nullable String addressBookId) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(200);
            baseResponse.setData(userService.associateUserCancel(stcd, organizationId, addressBookId));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 获取历史报警关联
     *
     * @return
     */
    @RequestMapping(value = "/historyUser", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse historyUser(@Nullable String stcd,
                                    @Nullable String monitorPara,
                                    @Nullable String alarmInterval,
                                    @Nullable String time,
                                    @Nullable String key,
                                    @Nullable String count,
                                    @Nullable String index) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(200);
            baseResponse.setData(userService.historyUser(stcd, monitorPara, alarmInterval, time, key, count, index));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 获取通讯录分组
     *
     * @return
     */
    @RequestMapping(value = "/allOrganization", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse allOrganization(
            @Nullable String count,
            @Nullable String index) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setResultCode(200);
            baseResponse.setData(userService.allOrganization(count, index));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 新增通讯录分组
     *
     * @return
     */
    @RequestMapping(value = "/addOrganization", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse addOrganization(@Nullable String organizationId) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(userService.addOrganization(organizationId));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 删除通讯录分组
     *
     * @return
     */
    @RequestMapping(value = "/delOrganization", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse delOrganization(@Nullable String organizationId) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(userService.delOrganization(organizationId));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 获取通讯录联系人
     *
     * @return
     */
    @RequestMapping(value = "/addressBookUser", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getAddressBookUser(@Nullable String organizationId,
                                           @Nullable String key,
                                           @Nullable String count,
                                           @Nullable String index) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(userService.addressBookUser(organizationId, key, count, index));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 移动通讯录人员到指定分组
     *
     * @return
     */
    @RequestMapping(value = "/moveToOrganization", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse moveToOrganization(@Nullable String beforeOrganizationId,
                                           @Nullable String organizationId,
                                           @Nullable String addressBookId) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(userService.moveToOrganization(beforeOrganizationId, organizationId, addressBookId));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 复制通讯录人员到指定分组
     *
     * @return
     */
    @RequestMapping(value = "/copyToOrganization", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse copyToOrganization(@Nullable String beforeOrganizationId,
                                           @Nullable String organizationId,
                                           @Nullable String addressBookId) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(userService.copyToOrganization(beforeOrganizationId, organizationId, addressBookId));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 删除联系人
     *
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse delUser(@Nullable String organizationId,
                                @Nullable String addressBookId) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(userService.delUser(organizationId, addressBookId));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 获取联系人详情
     *
     * @return
     */
    @RequestMapping(value = "/userDetail", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse userDetail(@Nullable String organizationId,
                                   @Nullable String addressBookId) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(userService.userDetail(organizationId, addressBookId));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 保存联系人数据
     *
     * @return
     */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse saveUser(@RequestBody ContactUser contactUser) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(userService.saveUser(contactUser));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 创建联系人
     *
     * @return
     */
    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse saveUser(@Nullable String organizationId) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setData(userService.createUser(organizationId));
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

}
