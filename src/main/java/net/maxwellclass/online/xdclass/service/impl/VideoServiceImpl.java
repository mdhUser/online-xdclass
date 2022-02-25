package net.maxwellclass.online.xdclass.service.impl;

import net.maxwellclass.online.xdclass.model.entity.Video;
import net.maxwellclass.online.xdclass.model.entity.VideoBanner;
import net.maxwellclass.online.xdclass.mapper.VideoMapper;
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
    public List<Video> getVideoAllList() {
        return videoMapper.videoList();
    }

    @Override
    public List<VideoBanner> lsitBanner() {
        return videoMapper.listBanner();
    }

    @Override
    public Video findDetailById(int videoId) {
        return videoMapper.findDetailById(videoId);
    }
}
