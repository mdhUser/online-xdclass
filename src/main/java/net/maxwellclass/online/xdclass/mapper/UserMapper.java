package net.maxwellclass.online.xdclass.mapper;

import net.maxwellclass.online.xdclass.model.entity.User;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/20 21:52
 */
public interface UserMapper {

      User findByPhone(String phone);

      int save(User user);

      User findByPhoneAndPwd(String phone, String pwd);
}
