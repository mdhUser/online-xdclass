package net.maxwellclass.online.xdclass.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Maxwell
 * 视频轮播图
 */

@Data
public class VideoBanner {

    private Integer id;
    private String url;
    private String img;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer weight;

}
