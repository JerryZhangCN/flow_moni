package com.flow.service.image;

import com.flow.domain.image.Image;
import com.flow.domain.tools.DataConstants;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-11 11:22
 */
public interface ImageService {
    Image getImage(String stcd);

    List<Image> getImages(String addvcd, String sttp, String end, String key, String count, String index);

    List<Image> historyImage(String stcd,String endTime);
}
