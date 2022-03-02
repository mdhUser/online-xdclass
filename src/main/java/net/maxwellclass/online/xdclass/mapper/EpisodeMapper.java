package net.maxwellclass.online.xdclass.mapper;

import net.maxwellclass.online.xdclass.model.entity.Episode;

public interface EpisodeMapper {

    Episode findFirstEpisodeById(int videoId);

}
