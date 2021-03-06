package net.maxwellclass.online.xdclass.service.impl;

import net.maxwellclass.online.xdclass.exception.MAXException;
import net.maxwellclass.online.xdclass.type.IsPay;
import net.maxwellclass.online.xdclass.mapper.*;
import net.maxwellclass.online.xdclass.model.entity.Episode;
import net.maxwellclass.online.xdclass.model.entity.PlayRecord;
import net.maxwellclass.online.xdclass.model.entity.VideoOrder;
import net.maxwellclass.online.xdclass.model.response.VideoOrderResponse;
import net.maxwellclass.online.xdclass.model.response.VideoResponse;
import net.maxwellclass.online.xdclass.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class VideoOrderServiceImpl implements VideoOrderService {


    @Autowired
    private VideoOrderMapper videoOrderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private EpisodeMapper episodeMapper;
    @Autowired
    private PlayRecordMapper playRecordMapper;

    /***
     * δΈεζδ½
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    @Transactional
    public int save(int userId, int videoId) {
        VideoOrder order = videoOrderMapper.findByUserIdAndVideoIdAndState(userId, videoId, IsPay.YES.getState());
        if (order != null) return 0;

        VideoResponse video = videoMapper.findDetailById(videoId);
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

        //ηζζ­ζΎθ?°ε½
        if (rows == 1) {
            Episode episode = episodeMapper.findFirstEpisodeById(videoId);
            if (episode == null) {
                throw new MAXException(-1, "θ§ι’ζ²‘ζιδΏ‘ζ―θ―·θΏθ₯δΊΊεζ£ζ₯οΌ");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setVideoId(episode.getVideoId());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setCreateTime(new Date());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setUserId(userId);
            playRecordMapper.saveRecord(playRecord);
        }

        return rows;
    }


    @Override
    public List<VideoOrderResponse> videoOrderList(Integer userId) {
        return videoOrderMapper.selectVideoOrderList(userId);
    }
}