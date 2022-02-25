package net.maxwellclass.online.xdclass.model.request;

import lombok.Data;

/**
 * @description: 登录 request
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/26 1:07
 */
@Data
public class LoginRequest {

    private String phone;
    private String pwd;

}
