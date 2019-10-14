package com.flow.service.image;

import com.flow.dao.mapper.ImageDao;
import com.flow.domain.image.Image;
import com.flow.domain.statistics.PageData;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-11 11:26
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;

    @Override
    public Image getImage(String stcd) {
        return imageDao.getImage(stcd);
    }

    @Override
    public PageData getImages(String addvcd, String sttp, String end, String key, String count, String index) {
        List<List<Object>> ob =imageDao.getImages(addvcd, sttp, end, key, count, index);
        return new PageData(ob.get(0), ob.get(1).get(0).toString());
    }

    @Override
    public List<Image> historyImage(String stcd, String endTime) {
        return imageDao.getHistoryImage(stcd,endTime);
    }
}
