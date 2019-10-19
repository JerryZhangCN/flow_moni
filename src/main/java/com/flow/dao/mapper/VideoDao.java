package com.flow.dao.mapper;

import com.flow.domain.tools.DataConstants;
import com.flow.domain.video.Video;
import com.flow.domain.video.VideoOnline;
import com.flow.domain.video.VideoProperty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-18 13:45
 */
@Mapper
@Repository
public interface VideoDao {

    List<Video> findAll();

    List<VideoProperty> getVideoProperty();

    VideoOnline getVideoOnline(@Param(DataConstants.REQUEST_PARAMS_STCD) String stcd);
}
