package net.maxwellclass.online.xdclass.service.impl;

import net.maxwellclass.online.xdclass.model.entity.User;
import net.maxwellclass.online.xdclass.mapper.UserMapper;
import net.maxwellclass.online.xdclass.service.UserService;
import net.maxwellclass.online.xdclass.utils.CommonUtils;
import net.maxwellclass.online.xdclass.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/21 8:58
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }

    @Override
    public int save(Map<String, String> userInfo) {
        User user = parseToUser(userInfo);
        if (null == user)
            return -1;
        return userMapper.save(user);
    }

    /**
     * 解析注册流程
     *
     * @param userInfo
     * @return
     */
    private User parseToUser(Map<String, String> userInfo) {
        if (userInfo.containsKey("phone")
                && userInfo.containsKey("pwd")
                && userInfo.containsKey("name")) {
            User user = new User();
            user.setName(userInfo.get("name"));
            user.setPhone(userInfo.get("phone"));
            user.setHeadImg(CommonUtils.getRandomImg());
            user.setCreateTime(new Date());
            String pwd = userInfo.get("pwd");
            //MD5加密
            user.setPwd(CommonUtils.MD5(pwd));
            return user;
        }

        return null;
    }

    /**
     * 用户信息正确返回token
     * @param phone
     * @param pwd
     * @return
     */
    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        User user = userMapper.findByPhoneAndPwd(phone, pwd);
        if (null == user)
            return null;
        else {
            String token = JWTUtils.geneJsonWebToken(user);
            return token;
        }
    }


}