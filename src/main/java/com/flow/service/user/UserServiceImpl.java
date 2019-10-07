package com.flow.service.user;

import com.flow.domain.user.User;
import com.google.common.util.concurrent.ListenableFuture;
import org.springframework.stereotype.Service;

/**
 * @author jerry
 * @date 2019-10-07 20:10
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public ListenableFuture<User> findCustomerByIdAsync(String userId) {
        return null;
    }

    @Override
    public User findById(String userId) {
        return null;
    }
}
