package com.flow.service.user;

import com.flow.domain.user.User;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * @author jerry
 * @date 2019-10-07 20:07
 */

public interface UserService {
    /**
     * 根据ID查询用户
     * @RequestParam userId
     * @return
     */
    ListenableFuture<User> findCustomerByIdAsync(String userId);

    User findById(String userId);
}
