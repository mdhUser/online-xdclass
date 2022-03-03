package net.maxwellclass.online.xdclass.model.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Maxwell课堂章节
 */

@Data
public class Chapter {


    private Integer id;
    private Integer videoId;
    private String title;
    private Integer ordered;
    private Date createTime;
    private List<Episode> episodeList;

}
