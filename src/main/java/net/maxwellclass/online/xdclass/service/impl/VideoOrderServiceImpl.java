package net.maxwellclass.online.xdclass.service.impl;

import net.maxwellclass.online.xdclass.exception.MAXException;
import net.maxwellclass.online.xdclass.exception.type.IsPay;
import net.maxwellclass.online.xdclass.mapper.*;
import net.maxwellclass.online.xdclass.model.entity.Episode;
import net.maxwellclass.online.xdclass.model.entity.PlayRecord;
import net.maxwellclass.online.xdclass.model.entity.Video;
import net.maxwellclass.online.xdclass.model.entity.VideoOrder;
import net.maxwellclass.online.xdclass.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private EpisodeMapper episodeMapper;
    @Autowired
    private PlayRecordMapper playRecordMapper;

    /***
     * 下单操作
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    @Transactional
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

        //生成播放记录
        if (rows == 1) {
            Episode episode = episodeMapper.findFirstEpisodeById(videoId);
            if (episode==null){
                throw new MAXException(-1,"视频没有集信息请运营人员检查！");
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

}