package com.flow.dao.mapper;

import com.flow.domain.tools.DataConstants;
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
    List<List<Object>> getOrganization(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                       @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                       @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index);

    List<List<Object>> getContactUser(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                      @Param(DataConstants.REQUEST_PARAMS_SELECT_TYPE) String selectType,
                                      @Param(DataConstants.REQUEST_PARAMS_ORGANIZATION_ID) String organizationId,
                                      @Param(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                      @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                      @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index);

    String associateUser(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                         @Param(DataConstants.REQUEST_PARAMS_ORGANIZATION_ID) String organizationId,
                         @Param(DataConstants.REQUEST_PARAMS_ADDRESS_BOOK_ID) String addressBookId);

    String associateUserCancel(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                               @Param(DataConstants.REQUEST_PARAMS_ORGANIZATION_ID) String organizationId,
                               @Param(DataConstants.REQUEST_PARAMS_ADDRESS_BOOK_ID) String addressBookId);


    List<List<Object>> historyUser(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                   @Param(DataConstants.REQUEST_PARAMS_MONITOR_PARA) String selectType,
                                   @Param(DataConstants.REQUEST_PARAMS_ALARM_INTERVAL) String organizationId,
                                   @Param(DataConstants.REQUEST_PARAMS_TIME) String time,
                                   @Param(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                   @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                   @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index);

}
