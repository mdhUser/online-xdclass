package net.maxwellclass.online.xdclass.mapper;

import net.maxwellclass.online.xdclass.model.entity.VideoOrder;
import net.maxwellclass.online.xdclass.model.response.VideoOrderResponse;

import java.util.List;

public interface VideoOrderMapper {


    /**
     * 查询用户是否购买此商品
     * @param userId
     * @param videoId
     * @param state
     * @return
     */
    VideoOrder findByUserIdAndVideoIdAndState(int userId,int videoId,int state);

    /**
     * 下单
     * @param videoOrder
     * @return
     */
    int saveOrder(VideoOrder videoOrder);

    /**
     * 查询用户视频下单列表
     * @param userId
     * @return
     */
    List<VideoOrderResponse> selectVideoOrderList(Integer userId);
}
