package net.maxwellclass.online.xdclass.service.impl;

import net.maxwellclass.online.xdclass.mapper.VideoMapper;
import net.maxwellclass.online.xdclass.model.response.VideoBannerResponse;
import net.maxwellclass.online.xdclass.model.response.VideoResponse;
import net.maxwellclass.online.xdclass.model.response.VideoResponseList;
import net.maxwellclass.online.xdclass.service.VideoService;
import net.maxwellclass.online.xdclass.utils.GuavaCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static net.maxwellclass.online.xdclass.config.CacheKeyManager.*;

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

    @Autowired
    private GuavaCache guavaCache;

    @Override
    public List<VideoResponseList> getVideoAllList() {

        try {
            Object o = guavaCache.getTenMinuteCache().get(INDEX_VIDEO_LIST_KEY, () ->
            {
                List<VideoResponseList> list = videoMapper.videoList();
                return list;
            });
            if (o instanceof List) {
                List<VideoResponseList> list = (List<VideoResponseList>) o;
                return list;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<VideoBannerResponse> lsitBanner() {

        try {
            Object cacheObj = guavaCache.getTenMinuteCache().get(INDEX_BANNER_KEY, () ->
                    {
                        List<VideoBannerResponse> bannerList = videoMapper.listBanner();
                        System.out.println("缓存中无数据，开始从数据库中找轮播图...");
                        return bannerList;
                    }
            );
            if (cacheObj instanceof List) {
                List<VideoBannerResponse> bannerList = (List<VideoBannerResponse>) cacheObj;
                return bannerList;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public VideoResponse findDetailById(int videoId) {

        String key = String.format(INDEX_VIDEO_DETAIL_KEY, videoId);
        try {
            Object o = guavaCache.getOneHourCache().get(key, () ->
            {
                VideoResponse vp = videoMapper.findDetailById(videoId);
                return vp;
            });
            if (o instanceof VideoResponse) {
                VideoResponse videoResponse = (VideoResponse) o;
                return videoResponse;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }
}
