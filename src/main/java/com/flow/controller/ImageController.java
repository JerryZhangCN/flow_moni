package com.flow.controller;

import com.alibaba.fastjson.JSONObject;
import com.flow.domain.BaseResponse;
import com.flow.domain.image.Image;
import com.flow.domain.statistics.CurveData;
import com.flow.domain.statistics.PageData;
import com.flow.domain.tools.DataConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jerry
 * @date 2019-10-11 10:03
 */
@RestController
@RequestMapping("api/image")
public class ImageController extends BaseController {


    /**
     * 获取图片
     *
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse image(@RequestParam(DataConstants.REQUEST_PARAMS_STCD) String stcd) {
        try {
            if (StringUtils.isBlank(stcd)) {
                return returnError(DataConstants.RESPONSE_PARAM_ERROR);
            }
            Image image = imageService.getImage(stcd);
            StringBuffer stringBuffer = new StringBuffer(DataConstants.BASE_IMAGE_IP);
            image.setPosition(stringBuffer.append(image.getPosition()).toString());
            return returnOk(image);
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 根据行政区划等条件获取图片列表
     *
     * @return
     */
    @RequestMapping(value = "/getImages", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getImages(@RequestParam(DataConstants.MONI_STATION_ADDVCD) String addvcd,
                                  @RequestParam(DataConstants.STATION_STATUS_TYPE) String sttp,
                                  @RequestParam(DataConstants.REQUEST_PARAMS_END) String end,
                                  @RequestParam(DataConstants.REQUEST_PARAMS_KEYS) String key,
                                  @RequestParam(DataConstants.REQUEST_PARAMS_PAGE_COUNT) String count,
                                  @RequestParam(DataConstants.REQUEST_PARAMS_PAGE_INDEX) String index) {
        try {
            PageData<List<Image>> images = imageService.getImages(addvcd, sttp, end, key, count, index);
            for (Image image : images.getData()) {
                StringBuffer stringBuffer = new StringBuffer(DataConstants.BASE_IMAGE_IP);
                image.setPosition(stringBuffer.append(image.getPosition()).toString());
            }
            return returnOk(images);
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 获取一个监测站点的历史图片
     *
     * @return
     */
    @RequestMapping(value = "/historyImages", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getHistoryImages(@RequestParam(DataConstants.REQUEST_PARAMS_STCD) String stcd,
                                         @RequestParam(DataConstants.REQUEST_PARAMS_END) String end) {
        try {
            List<Image> images = imageService.historyImage(stcd, end);
            for (Image image : images) {
                StringBuffer stringBuffer = new StringBuffer(DataConstants.BASE_IMAGE_IP);
                image.setPosition(stringBuffer.append(image.getPosition()).toString());
            }
            return returnOk(images);
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

}
