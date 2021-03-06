package net.maxwellclass.online.xdclass.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Maxwell课堂用户
 */

@Data
public class UserResponse {

    private String name;
    @JsonProperty("head_img")
    private String headImg;
    private String phone;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @JsonProperty("create_time")
    private Date createTime;


}
