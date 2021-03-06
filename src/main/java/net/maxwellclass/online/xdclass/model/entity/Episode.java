package net.maxwellclass.online.xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 *Maxwell集对象
 */

@Data
public class Episode {

    private Integer id;
    private String title;
    private Integer num;
    private Integer ordered;
    private String playUrl;
    private Integer chapterId;
    private Integer free;
    private Integer videoId;
    private Date createTime;


}
