package net.maxwellclass.online.xdclass.service.impl;

import net.maxwellclass.online.xdclass.mapper.VideoMapper;
import net.maxwellclass.online.xdclass.model.response.VideoBannerResponse;
import net.maxwellclass.online.xdclass.model.response.VideoResponse;
import net.maxwellclass.online.xdclass.model.response.VideoResponseList;
import net.maxwellclass.online.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/20 14:27
 */

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<VideoResponseList> getVideoAllList() {
        return videoMapper.videoList();
    }

    @Override
    public List<VideoBannerResponse> lsitBanner() {
        return videoMapper.listBanner();
    }

    @Override
    public VideoResponse findDetailById(int videoId) {
        return videoMapper.findDetailById(videoId);
    }
}
