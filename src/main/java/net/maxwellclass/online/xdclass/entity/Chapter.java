package net.maxwellclass.online.xdclass.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Maxwell课堂章节
 */

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Chapter {


    private Integer id;
    @JsonIgnore
    private Integer videoId;
    private String title;
    private Integer ordered;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private List<Episode> episodeList;

}
