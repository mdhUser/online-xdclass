package net.maxwellclass.online.xdclass.service.impl;

import net.maxwellclass.online.xdclass.exception.type.IsPay;
import net.maxwellclass.online.xdclass.mapper.UserMapper;
import net.maxwellclass.online.xdclass.mapper.VideoMapper;
import net.maxwellclass.online.xdclass.mapper.VideoOrderMapper;
import net.maxwellclass.online.xdclass.model.entity.Video;
import net.maxwellclass.online.xdclass.model.entity.VideoOrder;
import net.maxwellclass.online.xdclass.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;


@Service
public class VideoOrderServiceImpl implements VideoOrderService {


    @Autowired
    private VideoOrderMapper videoOrderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VideoMapper videoMapper;

    /***
     * 下单操作
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    public int save(int userId, int videoId) {
        VideoOrder order = videoOrderMapper.findByUserIdAndVideoIdAndState(userId, videoId, IsPay.YES.getState());
        if (order != null) return 0;

        Video video = videoMapper.findDetailById(videoId);
        VideoOrder vo = new VideoOrder();
        vo.setVideoId(video.getId());
        vo.setCreateTime(new Date());
        vo.setState(IsPay.YES.getState());
        vo.setVideoTitle(video.getTitle());
        vo.setVideoImg(video.getCoverImg());
        vo.setUserId(userId);
        vo.setTotalFee(video.getPrice());
        vo.setOutTradeNo(UUID.randomUUID().toString());

        int rows = videoOrderMapper.saveOrder(vo);

        return rows;
    }

}