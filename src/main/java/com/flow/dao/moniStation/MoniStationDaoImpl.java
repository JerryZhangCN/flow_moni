package com.flow.dao.moniStation;

import com.flow.domain.moniStation.MoniStation;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 22:29
 */
@Service
public class MoniStationDaoImpl  {



    @Select("EXEC [P_M_StationBasis] NULL,NULL,NULL,NULL,NULL,NULL")
    public List<MoniStation> queryAll() {
        return null;
    }
}
