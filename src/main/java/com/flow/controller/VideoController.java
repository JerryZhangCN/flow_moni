package com.flow.controller;

import com.flow.domain.BaseResponse;
import com.flow.domain.video.Video;
import com.flow.domain.video.VideoOnline;
import com.flow.domain.video.VideoProperty;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jerry
 * @date 2019-10-18 13:38
 */
@RestController
@RequestMapping("/api/video")
public class VideoController extends BaseController {

    /**
     * 获取测站监测视频信息
     *
     * @return
     */
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse checkUpdates() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<Video> videos = videoService.findAll().stream().filter(video -> video != null).collect(Collectors.toList());
            baseResponse.setData(videos);
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }


    /**
     * 获取视频分屏信息
     *
     * @return
     */
    @RequestMapping(value = "/videoProperty", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getVideoProperty() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<VideoProperty> videoProperty = videoService.getVideoProperty();
            baseResponse.setData(videoProperty);
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }

    /**
     * 获取视频监测信息
     *
     * @return
     */
    @RequestMapping(value = "/videoOnline", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getVideoOnLine(@Nullable String stcd) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            VideoOnline videoOnline = videoService.getVideoOnline(stcd);
            baseResponse.setData(videoOnline);
            return baseResponse;
        } catch (Exception e) {
            return returnError(e.getMessage());
        }
    }
}
