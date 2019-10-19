package com.flow.service.video;

import com.flow.domain.video.Video;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-18 13:40
 */
public interface VideoService {
    Video findByStcd(String stcd);

    List<Video> findAll();
}
