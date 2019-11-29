package com.flow.service.user;

import com.flow.domain.statistics.PageData;
import com.flow.domain.tools.BaseReturnData;
import com.flow.domain.tools.DataConstants;
import com.flow.domain.user.ContactUser;
import com.flow.domain.user.User;
import com.google.common.util.concurrent.ListenableFuture;
import org.apache.ibatis.annotations.Param;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 20:07
 */

public interface UserService {
    /**
     * 根据ID查询用户
     *
     * @return
     * @RequestParam userId
     */
    ListenableFuture<User> findCustomerByIdAsync(String userId);

    User findById(String userId);

    PageData getOrganization(String stcd, String count, String index);

    PageData getContactUser(String stcd, String selectType, String organizationId, String key, String count, String index);

    String associateUser(String stcd, String organozationId, String addressbookId);

    String associateUserCancel(String stcd, String organozationId, String addressbookId);

    PageData historyUser(String stcd,
                         String monitorPara,
                         String alarmInterval,
                         String time,
                         String key,
                         String count,
                         String index);

    PageData addressBookUser(String organizationId, String key, String count, String index);


    PageData allOrganization(String count, String index);

    BaseReturnData addOrganization(String organizationId);

    BaseReturnData delOrganization(String organizationId);

    BaseReturnData moveToOrganization(String beforeOrganizationId,
                                      String organizationId,
                                      String addressBookId);

    BaseReturnData copyToOrganization(String beforeOrganizationId,
                                      String organizationId,
                                      String addressBookId);

    /**
     * 删除用户
     *
     * @param organizationId
     * @param addressBookId
     * @return
     */
    BaseReturnData delUser(String organizationId, String addressBookId);

    ContactUser userDetail(String organizationId,
                           String addressBookId);


    /**
     * 保存用户数据
     *
     * @param contactUser
     * @return
     */
    BaseReturnData saveUser(ContactUser contactUser);


    /**
     * 获取所有的通讯录分组
     *
     * @param organizationId
     * @return
     */
    BaseReturnData createUser(@Param(DataConstants.REQUEST_PARAMS_ORGANIZATION_ID) String organizationId);
}
