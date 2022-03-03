package net.maxwellclass.online.xdclass.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Maxwell
 * 视频轮播图
 */

@Data
public class VideoBannerResponse {

    private String url;
    private String img;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @JsonProperty("create_time")
    private Date createTime;
    private Integer weight;

}
