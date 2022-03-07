package net.maxwellclass.online.xdclass.controller;

import net.maxwellclass.online.xdclass.model.response.VideoBannerResponse;
import net.maxwellclass.online.xdclass.model.response.VideoResponse;
import net.maxwellclass.online.xdclass.model.response.VideoResponseList;
import net.maxwellclass.online.xdclass.service.VideoService;
import net.maxwellclass.online.xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/20 14:31
 */
@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 轮播图列表
     *
     * @return
     */
    @GetMapping("/list_banner")
    public JsonData listBanner() {
        List<VideoBannerResponse> bannerList = videoService.lsitBanner();
        return JsonData.buildSuccess(bannerList);
    }

    /**
     *
     * 首页视频列表
     * @return
     */
    @RequestMapping(value = "/listVideo", method = RequestMethod.GET)
    public JsonData listVideo() {
        List<VideoResponseList> videos = videoService.getVideoAllList();
        return JsonData.buildSuccess(videos);
    }

    /**
     * 查询视频详情（章，集详情）
     *
     * @param videoId
     * @return
     */
    @GetMapping("/findDetailById")
    public JsonData findDetailById(@RequestParam(value = "video_id") int videoId) {
        VideoResponse video = videoService.findDetailById(videoId);
        return JsonData.buildSuccess(video);
    }

}
