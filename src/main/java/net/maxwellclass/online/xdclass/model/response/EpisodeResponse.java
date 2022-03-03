package net.maxwellclass.online.xdclass.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Maxwell集对象
 */

@Data

public class EpisodeResponse {

    @JsonIgnore
    private Integer id;
    private String title;
    private Integer num;
    private Integer ordered;
    @JsonProperty("play_url")
    private String playUrl;
    @JsonIgnore
    private Integer chapterId;
    private Integer free;
    @JsonIgnore
    private Integer videoId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty("create_time")
    private Date createTime;


}
