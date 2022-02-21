package net.maxwellclass.online.xdclass.exception.type;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/21 19:24
 */
public enum ExcepetionEnum {

    REGISTRY_FAIRY(101,"用户注册失败！"),
    PHONE_REPEAT(102,"手机号重复");


    private String msg;
    private Integer code;

    ExcepetionEnum(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
