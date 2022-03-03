package net.maxwellclass.online.xdclass.mapper;

import net.maxwellclass.online.xdclass.model.entity.PlayRecord;

public interface PlayRecordMapper {


    /**
     * 保存播放记录
     * @param playRecord
     * @return
     */
    int saveRecord(PlayRecord playRecord);

}
