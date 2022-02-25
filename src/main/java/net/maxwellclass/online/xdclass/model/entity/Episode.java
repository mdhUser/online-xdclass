package net.maxwellclass.online.xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 *Maxwell集对象
 */

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Episode {

    private Integer id;
    private String title;
    private Integer num;
    private Integer ordered;
    private String playUrl;
    @JsonIgnore
    private Integer chapterId;
    private Integer free;
    @JsonIgnore
    private Integer videoId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


}
