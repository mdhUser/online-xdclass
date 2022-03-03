package net.maxwellclass.online.xdclass.controller;

import net.maxwellclass.online.xdclass.model.entity.VideoOrder;
import net.maxwellclass.online.xdclass.model.request.VideoOrderRequest;
import net.maxwellclass.online.xdclass.model.response.VideoOrderResponse;
import net.maxwellclass.online.xdclass.service.VideoOrderService;
import net.maxwellclass.online.xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {

    @Autowired
    private VideoOrderService videoOrderService;

    @PostMapping("/save")
    public JsonData save(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute("user_id");
        int rows = videoOrderService.save(id, videoOrderRequest.getVideoId());
        return rows == 0 ? JsonData.buildError("视频已购买！") : JsonData.buildSuccess("视频已下单！");
    }

    @PostMapping("/videoOrderList")
    public JsonData videoOrderList(HttpServletRequest request){
        Integer id = (Integer) request.getAttribute("user_id");
        List<VideoOrderResponse> list = videoOrderService.videoOrderList(id);
        return JsonData.buildSuccess(list);
    }


}
