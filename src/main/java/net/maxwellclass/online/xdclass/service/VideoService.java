package net.maxwellclass.online.xdclass.service;

import net.maxwellclass.online.xdclass.model.response.VideoBannerResponse;
import net.maxwellclass.online.xdclass.model.response.VideoResponse;
import net.maxwellclass.online.xdclass.model.response.VideoResponseList;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/20 14:26
 */
public interface VideoService {


    List<VideoResponseList> getVideoAllList();

    List<VideoBannerResponse> lsitBanner();

    VideoResponse findDetailById(int videoId);
}
