package net.maxwellclass.online.xdclass.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import net.maxwellclass.online.xdclass.model.entity.Chapter;

import java.util.Date;
import java.util.List;

/**
 * Maxwell课堂视频
 */
@Data
public class VideoResponseList {

    @JsonIgnore
    private Integer id;
    private String title;
    private String summary;
    @JsonProperty("cover_img")
    private String coverImg;
    private Integer price;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @JsonProperty("create_time")
    private Date createTime;
    private Double point;

}
