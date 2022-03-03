package net.maxwellclass.online.xdclass.mapper;

import net.maxwellclass.online.xdclass.model.entity.User;
import net.maxwellclass.online.xdclass.model.response.UserResponse;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/20 21:52
 */
public interface UserMapper {

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    User findByPhone(String phone);

    /**
     * 保存用户
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 登录时根据手机号和密码查询
     * @param phone
     * @param pwd
     * @return
     */
    User findByPhoneAndPwd(String phone, String pwd);

    /**
     *
     * @param userId
     * @return
     */
    UserResponse findByUserId(Integer userId);
}
