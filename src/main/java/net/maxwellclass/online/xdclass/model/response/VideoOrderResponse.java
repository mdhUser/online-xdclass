package net.maxwellclass.online.xdclass.model.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Maxwell课堂视频订单
 */

@Data
public class VideoOrderResponse {


    @JsonProperty("out_trade_no")
    private String outTradeNo;
    private Integer state;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @JsonProperty("create_time")
    private Date createTime;
    @JsonProperty("total_fee")
    private Integer totalFee;
    @JsonProperty("video_id")
    private Integer videoId;
    @JsonProperty("video_title")
    private String videoTitle;
    @JsonProperty("video_img")
    private String videoImg;
    @JsonProperty("user_id")
    private Integer userId;

}
