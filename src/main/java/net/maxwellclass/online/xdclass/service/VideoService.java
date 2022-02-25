package net.maxwellclass.online.xdclass.service;

import net.maxwellclass.online.xdclass.model.entity.Video;
import net.maxwellclass.online.xdclass.model.entity.VideoBanner;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/20 14:26
 */
public interface VideoService {


    List<Video> getVideoAllList();

    List<VideoBanner> lsitBanner();

    Video findDetailById(int videoId);
}
