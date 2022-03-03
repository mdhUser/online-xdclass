package net.maxwellclass.online.xdclass.mapper;

import net.maxwellclass.online.xdclass.model.entity.Video;
import net.maxwellclass.online.xdclass.model.response.VideoBannerResponse;
import net.maxwellclass.online.xdclass.model.response.VideoResponse;
import net.maxwellclass.online.xdclass.model.response.VideoResponseList;

import java.util.List;

/**
 * @description: video dao
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/20 14:22
 */
public interface VideoMapper {


    /**
     * 查询所有视频列表
     *
     * @return
     */
    List<VideoResponseList> videoList();

    /**
     * 轮播图
     * @return
     */
    List<VideoBannerResponse> listBanner();


    /**
     * 查询视频详情
     * @param videoId
     * @return
     */
    VideoResponse findDetailById(int videoId);
}
