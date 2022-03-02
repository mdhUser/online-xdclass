package net.maxwellclass.online.xdclass.controller;

import net.maxwellclass.online.xdclass.model.request.LoginRequest;
import net.maxwellclass.online.xdclass.model.response.ResponseUser;
import net.maxwellclass.online.xdclass.service.UserService;
import net.maxwellclass.online.xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static net.maxwellclass.online.xdclass.exception.type.ExcepetionEnum.REGISTRY_FAIRY;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/20 21:45
 */
@RestController
@RequestMapping("/api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册接口
     *
     * @param userInfo
     * @return
     */
    @PostMapping("/register")
    public JsonData register(@RequestBody Map<String, String> userInfo) {
        int rows = userService.save(userInfo);
        return rows == 1 ?
                JsonData.buildSuccess("用户创建成功！") : JsonData.buildError(REGISTRY_FAIRY.getCode(), REGISTRY_FAIRY.getMsg());
    }

    /**
     * 跟据userid查询用户信息
     *
     * @param
     * @return
     */
    @GetMapping("/findUserInfoByToken")
    public JsonData findUserInfoByToken(HttpServletRequest request) {

        Integer userId = (Integer) request.getAttribute("user_id");
        if (userId == null) {
            return JsonData.buildError("查询失败");
        }

        ResponseUser user = userService.findByUserId(userId);

        return JsonData.buildSuccess(user);

    }

    /**
     * 登录接口
     *
     * @return
     */
    @PostMapping("/login")
    public JsonData login(@RequestBody LoginRequest loginRequest) {
        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());
        return token == null ? JsonData.buildError("登录失败，账号密码错误") : JsonData.buildSuccess(token);
    }

}