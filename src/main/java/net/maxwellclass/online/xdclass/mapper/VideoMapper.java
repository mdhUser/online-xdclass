package net.maxwellclass.online.xdclass.mapper;

import net.maxwellclass.online.xdclass.model.entity.Video;
import net.maxwellclass.online.xdclass.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Param;

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
     * @return
     */
    List<Video> videoList();


    List<VideoBanner> listBanner();

    Video findDetailById(@Param("videoId") int videoId);
}
