package net.maxwellclass.online.xdclass.service;

import net.maxwellclass.online.xdclass.model.entity.User;
import net.maxwellclass.online.xdclass.model.response.UserResponse;

import java.util.Map;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/21 8:58
 */
public interface UserService {


    int save(Map<String, String> userInfo);


    String findByPhoneAndPwd(String phone, String pwd);

    UserResponse findByUserId(Integer userId);
}