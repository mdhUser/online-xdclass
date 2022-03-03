package net.maxwellclass.online.xdclass.mapper;

import net.maxwellclass.online.xdclass.model.entity.Episode;

public interface EpisodeMapper {

    /**
     * 根据视频id查询集数
     * @param videoId
     * @return
     */
    Episode findFirstEpisodeById(int videoId);

}
