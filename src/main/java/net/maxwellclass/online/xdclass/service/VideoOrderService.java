package net.maxwellclass.online.xdclass.service;

import net.maxwellclass.online.xdclass.model.response.VideoOrderResponse;

import java.util.List;

public interface VideoOrderService {

    int save(int userId,int videoId);

    List<VideoOrderResponse> videoOrderList(Integer userId);
}
