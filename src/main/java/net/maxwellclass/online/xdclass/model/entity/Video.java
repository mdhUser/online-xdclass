package net.maxwellclass.online.xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Maxwell课堂视频
 */
@Data
public class Video {

    private Integer id;
    private String title;
    private String summary;
    private String coverImg;
    private Integer price;
    private Date createTime;
    private Double point;
    private List<Chapter> chapterList;

}
