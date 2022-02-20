package net.maxwellclass.online.xdclass.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Maxwell课堂用户
 */

@Data
public class User {

    private Integer id;
    private String name;
    private String pwd;
    private String headImg;
    private String phone;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


}
