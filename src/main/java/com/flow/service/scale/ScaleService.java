package com.flow.service.scale;


import com.flow.domain.area.Area;
import com.flow.domain.scale.Scale;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-07 22:31
 */
public interface ScaleService {

    List<Scale> findByType(String sttp,String type);
}
