package net.maxwellclass.online.xdclass.model.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * Maxwell课堂视频订单
 */

@Data
public class VideoOrderResponse {

    @JsonIgnore
    private Integer id;
    private String outTradeNo;
    private Integer state;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer totalFee;
    private Integer videoId;
    private String videoTitle;
    private String videoImg;
    private Integer userId;

}
