package com.flow.service.user;

import com.flow.domain.statistics.PageData;
import com.flow.domain.user.User;
import com.google.common.util.concurrent.ListenableFuture;

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

    PageData getContactUser(String stcd, String selectType,String organizationId,String key,String count, String index);

    String associateUser(String stcd,String organozationId,String addressbookId);

    String associateUserCancel(String stcd,String organozationId,String addressbookId);
}
