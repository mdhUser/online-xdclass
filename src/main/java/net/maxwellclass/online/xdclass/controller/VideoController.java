package net.maxwellclass.online.xdclass.controller;

import net.maxwellclass.online.xdclass.entity.Video;
import net.maxwellclass.online.xdclass.entity.VideoBanner;
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
    public JsonData indexBanner() {
        List<VideoBanner> bannerList = videoService.lsitBanner();
        return JsonData.buildSuccess(bannerList);
    }

    /**
     * 视频列表
     *
     * @return
     */
    @RequestMapping(value = "/listVideo", method = RequestMethod.GET)
    public JsonData listVideo() {
        List<Video> videos = videoService.getVideoAllList();
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
        Video video = videoService.findDetailById(videoId);
        return JsonData.buildSuccess(video);
    }

}
