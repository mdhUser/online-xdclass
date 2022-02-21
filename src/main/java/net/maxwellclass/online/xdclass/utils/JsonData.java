package net.maxwellclass.online.xdclass.utils;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/20 15:09
 */
public class JsonData {

    //状态码(0 成功，-1失败，1 处理中)
    private Integer code;
    //数据
    private Object data;
    //返回信息
    private String msg;

    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public JsonData(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public JsonData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //todo 成功不返回数据
    public static JsonData buildSuccess() {
        return new JsonData(0, null, "success!");
    }
    //todo 成功返回数据
    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, data, "success!");
    }
    //todo 失败返回错误信息
    public static JsonData buildError(String msg) {
        return new JsonData(-1, msg);
    }
    //todo 失败自定义状态码返回错误信息
    public static JsonData buildError(Integer code, String msg) {
        return new JsonData(code, msg);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
