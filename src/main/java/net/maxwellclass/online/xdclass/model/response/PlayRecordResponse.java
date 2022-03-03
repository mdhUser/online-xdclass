package net.maxwellclass.online.xdclass.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class PlayRecordResponse {

    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("video_id")
    private Integer videoId;
    @JsonProperty("current_num")
    private Integer currentNum;
    @JsonProperty("episode_id")
    private Integer episodeId;
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

}