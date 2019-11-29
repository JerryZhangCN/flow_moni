package com.flow.dao.mapper;

import com.flow.domain.tools.BaseReturnData;
import com.flow.domain.tools.DataConstants;
import com.flow.domain.user.ContactUser;
import com.flow.domain.user.Organization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jerry
 * @date 2019/10/25 14:19
 */
@Mapper
@Repository
public interface UserDao {
    /**
     * 获取联系人分组
     * @param stcd
     * @param count
     * @param index
     * @return
     */
    List<List<Object>> getOrganization(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                       @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                       @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index);

    /**
     * 获取联系人
     * @param stcd
     * @param selectType
     * @param organizationId
     * @param key
     * @param count
     * @param index
     * @return
     */
    List<List<Object>> getContactUser(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                      @Param(DataConstants.REQUEST_PARAMS_SELECT_TYPE) String selectType,
                                      @Param(DataConstants.REQUEST_PARAMS_ORGANIZATION_ID) String organizationId,
                                      @Param(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                      @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                      @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index);

    /**
     * 报警关联联系人
     * @param stcd
     * @param organizationId
     * @param addressBookId
     * @return
     */
    String associateUser(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                         @Param(DataConstants.REQUEST_PARAMS_ORGANIZATION_ID) String organizationId,
                         @Param(DataConstants.REQUEST_PARAMS_ADDRESS_BOOK_ID) String addressBookId);

    /**
     * 取消报警关联联系人
     * @param stcd
     * @param organizationId
     * @param addressBookId
     * @return
     */
    String associateUserCancel(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                               @Param(DataConstants.REQUEST_PARAMS_ORGANIZATION_ID) String organizationId,
                               @Param(DataConstants.REQUEST_PARAMS_ADDRESS_BOOK_ID) String addressBookId);

    /**
     * 获取历史报警关联人
     * @param stcd
     * @param selectType
     * @param organizationId
     * @param time
     * @param key
     * @param count
     * @param index
     * @return
     */
    List<List<Object>> historyUser(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                   @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String selectType,
                                   @Param(DataConstants.REQUEST_PARAMS_ALARM_INTERVAL) String organizationId,
                                   @Param(DataConstants.REQUEST_PARAMS_TIME) String time,
                                   @Param(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                   @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                   @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index);


    /**
     * 获取通讯录用户
     * @param organizationId
     * @param key
     * @param count
     * @param index
     * @return
     */
    List<List<Object>> addressBookUser(@Param(DataConstants.REQUEST_PARAMS_ORGANIZATION_ID) String organizationId,
                                       @Param(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                       @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                       @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index);


    /**
     * 获取所有的通讯录分组
     * @param count
     * @param index
     * @return
     */
    List<List<Object>> allOrganization(@Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                       @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index);


    /**
     * 新增通讯录分组
     * @param organizationId
     * @return
     */
    List<List<Object>> addOrganization(@Param(DataConstants.REQUEST_PARAMS_ORGANIZATION_ID) String organizationId);

    /**
     * 删除通讯录分组
     * @param organizationId
     * @return
     */
    BaseReturnData delOrganization(@Param(DataConstants.REQUEST_PARAMS_ORGANIZATION_ID) String organizationId);

    /**
     * 移动联系人到组
     * @param beforeOrganizationId
     * @param organizationId
     * @param addressBookId
     * @return
     */
    BaseReturnData moveToOrganization(@Param(DataConstants.REQUEST_PARAMS_BEFORE_ORGANIZATION_ID) String beforeOrganizationId,
                                      @Param(DataConstants.REQUEST_PARAMS_ORGANIZATION_ID) String organizationId,
                                      @Param(DataConstants.REQUEST_PARAMS_ADDRESS_BOOK_ID) String addressBookId);

    /**
     * 复制联系人到组
     * @param beforeOrganizationId
     * @param organizationId
     * @param addressBookId
     * @return
     */
    BaseReturnData copyToOrganization(@Param(DataConstants.REQUEST_PARAMS_BEFORE_ORGANIZATION_ID) String beforeOrganizationId,
                                      @Param(DataConstants.REQUEST_PARAMS_ORGANIZATION_ID) String organizationId,
                                      @Param(DataConstants.REQUEST_PARAMS_ADDRESS_BOOK_ID) String addressBookId);

    /**
     * 删除用户
     * @param organizationId
     * @param addressBookId
     * @return
     */
    BaseReturnData delUser(@Param(DataConstants.REQUEST_PARAMS_ORGANIZATION_ID) String organizationId,
                           @Param(DataConstants.REQUEST_PARAMS_ADDRESS_BOOK_ID) String addressBookId);


    /**
     * 获取用户详情
     * @param organizationId
     * @param addressBookId
     * @return
     */
    ContactUser userDetail(@Param(DataConstants.REQUEST_PARAMS_ORGANIZATION_ID) String organizationId,
                           @Param(DataConstants.REQUEST_PARAMS_ADDRESS_BOOK_ID) String addressBookId);


    /**
     * 保存用户数据
     * @param contactUser
     * @return
     */
    BaseReturnData saveUser(ContactUser contactUser);


    /**
     * 获取所有的通讯录分组
     * @param organizationId
     * @return
     */
    List<List<Object>> createUser(@Param(DataConstants.REQUEST_PARAMS_ORGANIZATION_ID) String organizationId);


}
