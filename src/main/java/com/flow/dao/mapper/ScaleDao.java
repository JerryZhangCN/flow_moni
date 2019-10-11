package com.flow.dao.mapper;


import com.flow.domain.area.Area;
import com.flow.domain.scale.Scale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 22:28
 */
@Mapper
@Repository
public interface ScaleDao {

    List<Scale> findByType(@Param("STTP") String sttp,@Param("type") String type);
}
