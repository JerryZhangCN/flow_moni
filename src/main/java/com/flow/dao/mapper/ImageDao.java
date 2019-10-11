package com.flow.dao.mapper;

import com.flow.domain.image.Image;
import com.flow.domain.tools.DataConstants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-11 11:26
 */
@Mapper
@Repository
public interface ImageDao {
    Image getImage(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd);

    List<Image> getImages(@Param(DataConstants.MONI_STATION_ADDVCD) String addvcd,
                          @Param(DataConstants.STATION_STATUS_TYPE) String sttp,
                          @Param(DataConstants.REQUEST_PARAMS_END) String end,
                          @Param(DataConstants.REQUEST_PARAMS_KEYS) String key,
                          @Param(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                          @Param(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index);


    List<Image> getHistoryImage(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd,@Param(DataConstants.REQUEST_PARAMS_END) String end);
}
