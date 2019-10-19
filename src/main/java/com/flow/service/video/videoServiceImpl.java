package com.flow.service.video;

import com.flow.dao.mapper.VideoDao;
import com.flow.domain.video.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-18 13:42
 */
@Service
public class videoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    @Override
    public Video findByStcd(String stcd) {
        return null;
    }

    @Override
    public List<Video> findAll() {
        return videoDao.findAll();
    }
}
