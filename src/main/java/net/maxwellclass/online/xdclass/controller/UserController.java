package net.maxwellclass.online.xdclass.controller;

import net.maxwellclass.online.xdclass.service.UserService;
import net.maxwellclass.online.xdclass.utils.JsonData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static net.maxwellclass.online.xdclass.exception.type.ExcepetionEnum.REGISTRY_FAIRY;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/20 21:45
 */
@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public JsonData regiser(@RequestBody Map<String, String> userInfo) {
        int rows = userService.save(userInfo);
        return rows == 1 ?
                JsonData.buildSuccess("用户创建成功！") : JsonData.buildError(REGISTRY_FAIRY.getCode(), REGISTRY_FAIRY.getMsg());
    }


}
