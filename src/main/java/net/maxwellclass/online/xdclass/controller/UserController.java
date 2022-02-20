package net.maxwellclass.online.xdclass.controller;

import net.maxwellclass.online.xdclass.entity.User;
import net.maxwellclass.online.xdclass.utils.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/20 21:45
 */
@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {




    public JsonData regiser(@RequestParam Map<String,String> userInfo){
           return JsonData.buildSuccess();
    }




}
