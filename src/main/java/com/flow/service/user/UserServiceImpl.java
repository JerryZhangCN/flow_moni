package com.flow.service.user;

import com.flow.dao.mapper.UserDao;
import com.flow.domain.statistics.PageData;
import com.flow.domain.tools.BaseReturnData;
import com.flow.domain.user.ContactUser;
import com.flow.domain.user.User;
import com.google.common.util.concurrent.ListenableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 20:10
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public ListenableFuture<User> findCustomerByIdAsync(String userId) {
        return null;
    }

    @Override
    public User findById(String userId) {
        return null;
    }

    @Override
    public PageData getOrganization(String stcd, String count, String index) {
        List<List<Object>> ob = userDao.getOrganization(stcd, count, index);
        return new PageData(ob.get(0), ob.get(1).get(0).toString());
    }

    @Override
    public PageData getContactUser(String stcd, String selectType, String organizationId, String key, String count, String index) {
        List<List<Object>> ob = userDao.getContactUser(stcd, selectType, organizationId, key, count, index);
        return new PageData(ob.get(0), ob.get(1).get(0).toString());
    }

    @Override
    public String associateUser(String stcd, String organozationId, String addressbookId) {
        return userDao.associateUser(stcd, organozationId, addressbookId);
    }

    @Override
    public String associateUserCancel(String stcd, String organozationId, String addressbookId) {
        return userDao.associateUserCancel(stcd, organozationId, addressbookId);
    }

    @Override
    public PageData historyUser(String stcd, String monitorPara, String alarmInterval, String time, String key, String count, String index) {
        List<List<Object>> ob = userDao.historyUser(stcd, monitorPara, alarmInterval, time, key, count, index);
        return new PageData(ob.get(0), ob.get(1).get(0).toString());
    }

    @Override
    public PageData addressBookUser(String organizationId, String key, String count, String index) {
        List<List<Object>> ob = userDao.addressBookUser(organizationId, key, count, index);
        return new PageData(ob.get(0), ob.get(1).get(0).toString());
    }

    @Override
    public PageData allOrganization(String count, String index) {
        List<List<Object>> ob = userDao.allOrganization(count, index);
        return new PageData(ob.get(0), ob.get(1).get(0).toString());
    }

    @Override
    public BaseReturnData addOrganization(String organizationId) {
        return (BaseReturnData) userDao.createUser(organizationId).get(1).get(0);
    }

    @Override
    public BaseReturnData delOrganization(String organizationId) {
        return userDao.delOrganization(organizationId);
    }

    @Override
    public BaseReturnData moveToOrganization(String beforeOrganizationId, String organizationId, String addressBookId) {
        return userDao.moveToOrganization(beforeOrganizationId, organizationId, addressBookId);
    }

    @Override
    public BaseReturnData copyToOrganization(String beforeOrganizationId, String organizationId, String addressBookId) {
        return userDao.copyToOrganization(beforeOrganizationId, organizationId, addressBookId);
    }

    @Override
    public BaseReturnData delUser(String organizationId, String addressBookId) {
        return userDao.delUser(organizationId, addressBookId);
    }

    @Override
    public ContactUser userDetail(String organizationId, String addressBookId) {
        return userDao.userDetail(organizationId, addressBookId);
    }

    @Override
    public BaseReturnData saveUser(ContactUser contactUser) {
        return userDao.saveUser(contactUser);
    }

    @Override
    public BaseReturnData createUser(String organizationId) {
        return (BaseReturnData) userDao.createUser(organizationId).get(1).get(0);
    }
}
