package net.maxwellclass.online.xdclass.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import net.maxwellclass.online.xdclass.model.entity.Episode;

import java.util.Date;
import java.util.List;

/**
 * Maxwell课堂章节
 */

@Data
public class ChapterResponse {

    @JsonIgnore
    private Integer id;
    @JsonIgnore
    private Integer videoId;
    private String title;
    private Integer ordered;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @JsonProperty("create_time")
    private Date createTime;
    @JsonProperty("episode_list")
    private List<EpisodeResponse> episodeList;

}
