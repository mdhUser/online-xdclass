package net.maxwellclass.online.xdclass.exception;

/**
 * @description:自定义异常
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/20 20:53
 */
public class MAXException extends RuntimeException {

    private Integer code;

    private String msg;

    public MAXException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
